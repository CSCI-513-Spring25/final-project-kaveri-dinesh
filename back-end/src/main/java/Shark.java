import java.awt.geom.Point2D;
import java.util.Random;

class Shark extends Monster{
    Point2D location;
    @Override
    public void move() {
        // TODO Auto-generated method stub
        int xCoordinate=(int)location.getX();
        int yCoordinate=(int)location.getY();
        Random random = new Random();
        int direction = random.nextInt(0,4);
        char[][] grid=Game.getGrid();
        grid[xCoordinate][yCoordinate]=Character.MIN_VALUE;
        switch(direction){
            case 0:
            {
                if(xCoordinate-1>=super.xfloor)
                    xCoordinate--;
                break;
            }
            case 1:
            {
                if(yCoordinate+1<=super.yceiling)
                    yCoordinate++;
                break;
            }
            case 2:
            {
                if(xCoordinate+1<=super.xceiling)
                    xCoordinate++;
                break;
            }
            case 3:
            {
                if(yCoordinate-1<=super.yfloor)
                    yCoordinate--;                
                break;
            }
        }
        if(grid[xCoordinate][yCoordinate]!='M'){
            location = new Point2D.Float(xCoordinate,yCoordinate);
            grid[xCoordinate][yCoordinate]='M';
        }
    }
    Shark(int x,int y){
        this.location=new Point2D.Float(x,y);
    }
}
