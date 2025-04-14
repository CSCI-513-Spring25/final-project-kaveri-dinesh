import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Random;
public class ColumbusShip extends Observable{
    private Point2D coordinate;  
    private Random random;  
    public ColumbusShip(){
        // random=new Random();
        // coordinate=new Point2D.Float(random.nextInt(0,10),random.nextInt(0,10));
        coordinate = new Point2D.Float(19,19);
    }
    public int getX(){
        return (int)coordinate.getX();
    }
    public int getY(){
        return (int)coordinate.getY();
    }
    private void setCoordinate(Point2D point){
        coordinate=point;
        setChanged();
        notifyObservers(point);
    }
    public void moveEast(Game game){
        char[][] grid=game.getGrid();
        int xCoordinate = getX();
        int yCoordinate = getY();        
        if(yCoordinate+1<20&&!game.containsObject(xCoordinate, yCoordinate+1)){
            if(grid[xCoordinate][yCoordinate+1]=='T')game.setWinner("Columbus");
            game.updateGrid(xCoordinate, yCoordinate, ' ');
            game.updateGrid(xCoordinate, yCoordinate+1, 'C');            
            setCoordinate(new Point2D.Float(xCoordinate,yCoordinate+1));            
        }
    }
    public void moveWest(Game game)
    {
        char[][] grid=game.getGrid();
        int xCoordinate = getX();
        int yCoordinate = getY();        
        if(yCoordinate-1>=0 && !game.containsObject(xCoordinate, yCoordinate-1)){
            if(grid[xCoordinate][yCoordinate-1]=='T')game.setWinner("Columbus");
            game.updateGrid(xCoordinate, yCoordinate, ' ');
            game.updateGrid(xCoordinate, yCoordinate-1, 'C');
            setCoordinate(new Point2D.Float(xCoordinate,yCoordinate-1));
        }
    }
    public void moveNorth(Game game){
        char[][] grid=game.getGrid();
        int xCoordinate = getX();
        int yCoordinate = getY();        
        if(xCoordinate-1>=0 && !game.containsObject(xCoordinate-1, yCoordinate)){
            if(grid[xCoordinate-1][yCoordinate]=='T')game.setWinner("Columbus");
            game.updateGrid(xCoordinate, yCoordinate, ' ');
            game.updateGrid(xCoordinate-1, yCoordinate, 'C');
            setCoordinate(new Point2D.Float(xCoordinate-1,yCoordinate));
        }        
    }
    public void moveSouth(Game game){
        char[][] grid=game.getGrid();
        int xCoordinate = getX();
        int yCoordinate = getY();        
        if(xCoordinate+1<=19 && !game.containsObject(xCoordinate+1, yCoordinate)){
            if(grid[xCoordinate+1][yCoordinate]=='T')game.setWinner("Columbus");
            game.updateGrid(xCoordinate, yCoordinate, ' ');
            game.updateGrid(xCoordinate+1, yCoordinate, 'C');
            setCoordinate(new Point2D.Float(xCoordinate+1,yCoordinate));
        }
    }
}
