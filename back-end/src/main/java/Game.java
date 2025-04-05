import java.util.Arrays;
public class Game {
    private static char[][] grid=new char[10][10];  
    private ColumbusShip ship;  
    public static void updateGrid(int x,int y,char value){
        grid[y][x]=value;
    }
    public Game(){
        if(ship==null)ship=new ColumbusShip();
        initializeGrid();
    }
    public char[][] initializeGrid(){  
        for(int i=0;i<grid.length;i++)Arrays.fill(grid[i],' ') ;
        
        grid[ship.getY()][ship.getX()]='C';    
        System.out.println(grid[ship.getY()][ship.getX()]);
        return grid;
    }
    public static char[][] getGrid(){
        
        return grid;
    }
    public ColumbusShip getColumbusShip(){
        return ship;
    }
}
