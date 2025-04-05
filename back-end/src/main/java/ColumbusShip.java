import java.awt.geom.Point2D;
import java.util.Random;
public class ColumbusShip {
    private Point2D coordinate;  
    private Random random;  
    public ColumbusShip(){
        random=new Random();
        coordinate=new Point2D.Float(random.nextInt(0,10),random.nextInt(0,10));
    }
    public int getX(){
        return (int)coordinate.getX();
    }
    public int getY(){
        return (int)coordinate.getY();
    }
}
