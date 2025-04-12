import java.util.Arrays;
import java.util.Random;
public class Game {
    private static char[][] grid=new char[10][10];  
    private ColumbusShip ship;  
    private Random random;
    PirateFactory slowPirateFactory;
    PirateFactory fasPirateFactory;
    public void updateGrid(int x,int y,char value){
        grid[x][y]=value;        
    }
    public Game(){         
            if(ship==null)ship=new ColumbusShip();
            slowPirateFactory = new SlowPirateShipFactory();
            fasPirateFactory = new FastPirateShipFactory(); 
            random = new Random();
            initializeGrid();
    }
    public char[][] initializeGrid(){
        grid=new char[10][10];
        for(int i=0;i<grid.length;i++)Arrays.fill(grid[i],Character.MIN_VALUE) ;         
        grid[ship.getX()][ship.getY()]='C';             
        addIslands();
        addPirateShips();
        return grid;
    }
    public static char[][] getGrid(){        
        return grid;
    }
    public ColumbusShip getColumbusShip(){
        return ship;
    }
    public Game play(int keyEvent){
        if(keyEvent==37)ship.moveWest(this);
        else if(keyEvent==38)ship.moveNorth(this);
        else if(keyEvent==39)ship.moveEast(this);
        else if(keyEvent==40)ship.moveSouth(this);
        // printPirateLocations();
        return this;
    }
    private void printPirateLocations(){
        for(int i=0;i<=9;i++){
            for(int j=0;j<10;j++){
                if(grid[i][j]=='P')System.out.println("X: "+i+", Y: "+j);
            }
        }
    }    
    public void addPirateShips(){
        int piratesCount = 2;		
        // System.out.println("Adding Pirate Ships");
        while(piratesCount>0)
		{
			int xCoordinate = random.nextInt(0, 10);
			int yCoordinate = random.nextInt(0, 10);
			//Before assigning Pirate ships, Make sure that location is not occupied by some other island/ship 
			if(grid[xCoordinate][yCoordinate]!='C' && grid[xCoordinate][yCoordinate] != 'P' && grid[xCoordinate][yCoordinate] != 'I')
			{
				grid[xCoordinate][yCoordinate] = 'P';		
                PirateShip pirateShip=slowPirateFactory.getNewPirateShip(xCoordinate, yCoordinate);	
                ship.addObserver(pirateShip);					
				piratesCount--;
			}
		} 
        piratesCount=2;
        while(piratesCount>0)
		{
			int xCoordinate = random.nextInt(0, 10);
			int yCoordinate = random.nextInt(0, 10);
			//Before assigning Pirate ships, Make sure that location is not occupied by some other island/ship 
			if(grid[xCoordinate][yCoordinate]!='C' && grid[xCoordinate][yCoordinate] != 'P' && grid[xCoordinate][yCoordinate] != 'I')
			{
				grid[xCoordinate][yCoordinate] = 'P';		
                PirateShip pirateShip=fasPirateFactory.getNewPirateShip(xCoordinate, yCoordinate);	
                ship.addObserver(pirateShip);					
				piratesCount--;
			}
		}         
    }
    public void addIslands(){
        int islandCount = 3;
        Random random = new Random();
        while(islandCount>0){
            int xCoordinate = random.nextInt(0, 10);
			int yCoordinate = random.nextInt(0, 10);
			//Before assigning Pirate ships, Make sure that location is not occupied by some other island/ship 
			if(grid[xCoordinate][yCoordinate]!='C' && grid[xCoordinate][yCoordinate] != 'P' && grid[xCoordinate][yCoordinate] != 'I')
			{
				grid[xCoordinate][yCoordinate] = 'I';
				islandCount--;
			}
        }
    }
}
