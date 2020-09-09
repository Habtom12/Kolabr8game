package koala.modifiers.firearms;

import java.awt.Point;

import koala.game.Bullet;
import koala.game.PlayerTank;
import koala.game.Tank;
import koala.modifiers.movement.SimpleMotion;

public class SpreadFireArm extends AbstractFireArm {

	@Override
	public void fireWeapon(Tank theShip) {
		if(theShip instanceof PlayerTank){
			direction = 1;
		}
		else{
			direction = -1;
		}
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		Point vertical = new Point(0,-10*direction);
		Point left = new Point(1,-9*direction);
		Point right = new Point(-1,-9*direction);
		
		Bullet bullet0 = new Bullet(location, left, 4, new SimpleMotion(), theShip);
		Bullet bullet1 = new Bullet(location, right, 4, new SimpleMotion(), theShip);
		Bullet bullet2 = new Bullet(location, vertical, 4, new SimpleMotion(), theShip);

		bullets = new Bullet[3];
		bullets[0] = bullet0;
		bullets[1] = bullet1;
		bullets[2] = bullet2;
				
		this.setChanged();
		this.notifyObservers();

	}

}
