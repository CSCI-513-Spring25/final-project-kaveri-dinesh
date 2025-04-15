import java.util.Observable;
import java.util.Observer;
import java.awt.geom.Point2D;

class SlowPirateShip implements PirateShip{
    private Point2D pirateLocation;
    public SlowPirateShip(int x,int y){
        pirateLocation=new Point2D.Float(x,y);
    }
    @Override
    public void update(Observable ship,Object game){
        if(ship instanceof ColumbusShip){
            ColumbusShip columbusShip=(ColumbusShip)ship;
            movePirateShip(Game.getGrid(),columbusShip,(Game)game);
        }
    }
	public Point2D getPirateLocation(){
		return this.pirateLocation;
	}  
    public void movePirateShip(char[][] oceanGrid,ColumbusShip ship,Game game){
		if(game.getWinner()!=null)return;
        int px = (int)pirateLocation.getX();
		int py = (int)pirateLocation.getY();
		int cx = (int)ship.getX();
		int cy = (int)ship.getY();
		oceanGrid[px][py]=Character.MIN_VALUE;
		//If Columbus Ship is below the Pirate ship
		if(px-cx<0 && px+1<20&&px+1>=0&& oceanGrid[px+1][py]!='I'&&oceanGrid[px+1][py]!='P'
		&& oceanGrid[px+1][py]!='Q' && oceanGrid[px+1][py]!='T')
			px++;
		// If Columbus Ship is above Pirate ship
		else if(px-cx>0 && px-1>=0&&oceanGrid[px-1][py]!='I'&&oceanGrid[px-1][py]!='P'
		&& oceanGrid[px-1][py]!='Q' && oceanGrid[px-1][py]!='T')
		    px--;
		//If Columbus ship is towards right side of the Pirate ship
		if(py-cy<0 && py+1<20&&py+1>=0&& oceanGrid[px][py+1]!='I'&&oceanGrid[px][py+1]!='P'
		&& oceanGrid[px][py+1]!='Q'&& oceanGrid[px][py+1]!='T')
		    py++;		
		//If Columbus ship is towards left side of the Pirate Ship
		else if(py-cy>0 && py-1<20&&py-1>=0&&oceanGrid[px][py-1]!='I'&&oceanGrid[px][py-1]!='P'
		&& oceanGrid[px][py-1]!='Q'&& oceanGrid[px][py-1]!='T')
		    py--;
		pirateLocation.setLocation(px, py);	
		if(cx==px&&py==cy){
			game.setWinner("Pirate");
			game.setColumbusShip(null);
			System.out.println("Pirate Captured Columbus");
		}
		if(oceanGrid[px][py]=='W'){
			pirateLocation.setLocation(game.newRandomLocation(px, py));
		}
		oceanGrid[(int)pirateLocation.getX()][(int)pirateLocation.getY()]='P';
		// System.out.println("Updating slow pirate location: x: "+ px+", py: "+py);
    }
}
