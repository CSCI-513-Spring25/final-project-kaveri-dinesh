import java.util.Arrays;
public class Game {
    private static char[][] grid=new char[10][10];  
    private ColumbusShip ship;  
    public void updateGrid(int x,int y,char value){
        grid[x][y]=value;        
    }
    public Game(){
        if(ship==null)ship=new ColumbusShip();
        initializeGrid();
    }
    public char[][] initializeGrid(){  
        for(int i=0;i<grid.length;i++)Arrays.fill(grid[i],' ') ;
        
        grid[ship.getX()][ship.getY()]='C';    
         
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
        return this;
    }
}
