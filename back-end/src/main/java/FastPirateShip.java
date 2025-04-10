import java.awt.geom.Point2D;
import java.util.Observable;
class FastPirateShip implements PirateShip{
    private Point2D pirateLocation;
    public FastPirateShip(int x,int y){
        pirateLocation=new Point2D.Float(x,y);
    }
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void movePirateShip(char[][] oceanGrid, ColumbusShip ship) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'movePirateShip'");
    }
}