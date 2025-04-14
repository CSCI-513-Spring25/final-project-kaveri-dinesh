import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Random;
class FastPirateShip implements PirateShip{
    private Point2D pirateLocation;
    public FastPirateShip(int x,int y){
        pirateLocation=new Point2D.Float(x,y);
    }
    @Override
    public void update(Observable ship, Object arg) {
        // TODO Auto-generated method stub
        if(ship instanceof ColumbusShip){
            ColumbusShip columbusShip=(ColumbusShip)ship;
            movePirateShip(Game.getGrid(),columbusShip);
        }        
    }
    public Point2D getPirateLocation(){
        return this.pirateLocation;
    }
    @Override
    public void movePirateShip(char[][] oceanGrid, ColumbusShip ship) {
        // TODO Auto-generated method stub
        Random random = new Random();
        int rDirection = random.nextInt(0,4);
        switch (rDirection)
        {
            case 0: pirateLocation = moveUp(oceanGrid);break;
            case 1: pirateLocation = moveRight(oceanGrid);break;
            case 2: pirateLocation = moveDown(oceanGrid);break;
            case 3: pirateLocation = moveLeft(oceanGrid);break;
        }
    }
    public Point2D moveUp(char[][] oceanGrid)
    {
        int px = (int)pirateLocation.getX();
		int py = (int)pirateLocation.getY();
        oceanGrid[px][py]=Character.MIN_VALUE;
        if(px-1>=0 && oceanGrid[px-1][py]!='I'&&oceanGrid[px-1][py]!='C'&&oceanGrid[px-1][py]!='P')px--;
        oceanGrid[px][py]='P';
        return new Point2D.Float(px,py);
    }
    public Point2D moveRight(char[][] oceanGrid)
    {
        int px = (int)pirateLocation.getX();
		int py = (int)pirateLocation.getY();
        oceanGrid[px][py]=Character.MIN_VALUE;
        if(py+1<10 && oceanGrid[px][py+1]!='I'&&oceanGrid[px][py+1]!='C'&&oceanGrid[px][py+1]!='P')py++;
        oceanGrid[px][py]='P';
        return new Point2D.Float(px,py);
    }
    public Point2D moveDown(char[][] oceanGrid)
    {
        int px = (int)pirateLocation.getX();
		int py = (int)pirateLocation.getY();
        oceanGrid[px][py]=Character.MIN_VALUE;
        if(px+1<10 && oceanGrid[px+1][py]!='I'&&oceanGrid[px+1][py]!='C'&&oceanGrid[px+1][py]!='P')px++;
        oceanGrid[px][py]='P';
        return new Point2D.Float(px,py);
    }
    public Point2D moveLeft(char[][] oceanGrid)
    {
        int px = (int)pirateLocation.getX();
		int py = (int)pirateLocation.getY();
        oceanGrid[px][py]=Character.MIN_VALUE;
        if(py-1>=0 && oceanGrid[px][py-1]!='I'&&oceanGrid[px][py-1]!='C'&&oceanGrid[px][py-1]!='P')py--;
        oceanGrid[px][py]='P';
        return new Point2D.Float(px,py);
    }
}