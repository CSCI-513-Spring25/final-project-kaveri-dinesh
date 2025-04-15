import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Game {
    private static char[][] grid=new char[20][20];  
    private ColumbusShip ship;  
    private Random random;
    PirateFactory slowPirateFactory;
    PirateFactory fasPirateFactory;
    List<PirateShip>pirateShips;
    WhirlpoolComposite whirlpools;
    Monster creatures;
    String winner;
    public void updateGrid(int x,int y,char value){
        grid[x][y]=value;
    }
    public Game(){         
            if(ship==null)ship=new ColumbusShip();
            slowPirateFactory = new SlowPirateShipFactory();
            fasPirateFactory = new FastPirateShipFactory(); 
            random = new Random();
            whirlpools=new WhirlpoolComposite();             
            pirateShips = new ArrayList<>();
            creatures = new Monster();
            initializeGrid();
            addCreatures(2);  
                   
    }
    public boolean containsObject(int x,int y){
        return grid[x][y]=='C'|| grid[x][y]=='P' || grid[x][y]=='Q'|| grid[x][y]=='I' || grid[x][y]=='W';
    }
    public List<PirateShip> getPirateShips()
    {
        return this.pirateShips;
    }
    public char[][] initializeGrid(){
        grid=new char[20][20];
        for(int i=0;i<grid.length;i++)Arrays.fill(grid[i],Character.MIN_VALUE) ;         
        grid[ship.getX()][ship.getY()]='C';   
        // grid[17][19]='T';                 
        addIslands();
        addWhirlpool(10,10);        
        addWhirlpool(15, 15);
        addWhirlpool(10,15);
        return grid;
    }
    public void setWinner(String winner){
        this.winner = winner;
    }
    public void setColumbusShip(ColumbusShip ship){
        this.ship=ship;
    }
    public String getWinner(){
        return winner;
    }
    public static char[][] getGrid(){        
        return grid;
    }
    public ColumbusShip getColumbusShip(){
        return ship;
    }
    public Game play(int keyEvent){
        if(winner==null){
            if(keyEvent==37)ship.moveWest(this);
        else if(keyEvent==38)ship.moveNorth(this);
        else if(keyEvent==39)ship.moveEast(this);
        else if(keyEvent==40)ship.moveSouth(this);
        if(pirateShips.size()<4)
            addPirateShips();
        creatures.move(this);             
        }
        return this;
    }      
    public void addPirateShips(){        		
            PirateShip pirateShip;
            int pirateCount=1;
            int xCoordinate;
            int yCoordinate;
            while(pirateCount>0){
                 xCoordinate = random.nextInt(0, 2);
                 if(xCoordinate==0){
                    xCoordinate=18;yCoordinate=0;
                 }
                 else{
                    xCoordinate=19;yCoordinate=1;
                 }		                 	
                if(!containsObject(xCoordinate, yCoordinate) && !(xCoordinate==19&&yCoordinate==0))
			{
				grid[xCoordinate][yCoordinate] = 'P';		
                pirateShip=slowPirateFactory.getNewPirateShip(xCoordinate, yCoordinate);	
                ship.addObserver(pirateShip);	
                pirateShips.add(pirateShip);
                pirateCount--;                
			}    
            }
			//Before assigning Pirate ships, Make sure that location is not occupied by some other island/ship 
			  pirateCount=1;
              while(pirateCount>0){
                xCoordinate = random.nextInt(0, 20);
			 yCoordinate = 10;
			//Before assigning Pirate ships, Make sure that location is not occupied by some other island/ship 
			if(!containsObject(xCoordinate, yCoordinate) &&!(xCoordinate==19&&yCoordinate==0))
			{
				grid[xCoordinate][yCoordinate] = 'P';		
                pirateShip=fasPirateFactory.getNewPirateShip(xCoordinate, yCoordinate);	
                ship.addObserver(pirateShip);	
                pirateShips.add(pirateShip);
                pirateCount--;
			}
            }             		 
		}         
    public void addIslands(){
        int islandCount = 3;
        Random random = new Random();
        while(islandCount>0){
            int xCoordinate = random.nextInt(0, 20);
			int yCoordinate = random.nextInt(0, 20);
			//Before assigning Pirate ships, Make sure that location is not occupied by some other island/ship 
			if(!containsObject(xCoordinate, yCoordinate) && !(xCoordinate==19&&yCoordinate==0))
			{
				grid[xCoordinate][yCoordinate] = 'I';
				islandCount--;
			}
        }
        grid[19][0]='Q';        
    }
    public void addCreatures(int monsterCount)
    {
        while(monsterCount>0)
        {
            int xCoordinate = random.nextInt(0,20);
            int yCoordinate = random.nextInt(0,20);
            if(!this.containsObject(xCoordinate, yCoordinate)&&!(xCoordinate==19&&yCoordinate==0)
            &&xCoordinate>=16&&xCoordinate<=19&&yCoordinate>=8&&yCoordinate<=11&&grid[xCoordinate][yCoordinate]!='M')
            {
                creatures.addMonster(new Shark(xCoordinate,yCoordinate));
                grid[xCoordinate][yCoordinate]='M';
                monsterCount--;
            }
        }
    }
    public void addWhirlpool(int x,int y){
        if(!containsObject(x,y)){
            Whirlpool whirlpool = new Whirlpool(x, y);
            whirlpools.addWhirlpool(whirlpool);
            grid[x][y]='W';
        }
    }
    public Point2D newRandomLocation(int x,int y){
        Point2D newLocation = whirlpools.newRandomLocation(x, y);
        int nx = (int)newLocation.getX();int ny=(int)newLocation.getY();
        if(nx-1>=0&&!containsObject(nx-1, ny))nx--;
        else if(nx+1<=19&&!containsObject(nx+1, ny))nx++;
        else if(ny-1>=0&&!containsObject(nx, ny-1))ny--;
        else if(ny+1<=19&&!containsObject(nx, ny+1))ny++;
        System.out.println("new WhirlPool location: X: "+nx+", Y: "+ny);
        return new Point2D.Float(nx,ny);
    }
    public boolean noObstacles(int x,int y){
        return grid[x][y]!='I'&&grid[x][y]!='Q';
    }
}
