package koala.modifiers.firearms;

import java.awt.Point;

import koala.game.Bullet;
import koala.game.Tank;
import koala.modifiers.movement.SimpleMotion;

public class SpreadBomb extends AbstractFireArm {

	@Override
	public void fireWeapon(Tank theShip) {
		super.fireWeapon(theShip);
		Point location = theShip.getLocationPoint();
		Point speed = theShip.getSpeed();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		Point left = new Point(3,speed.y/2);
		Point right = new Point(-3,speed.y/2);
		
		Bullet bullet0 = new Bullet(location, left, 10, new SimpleMotion(), theShip);
		Bullet bullet1 = new Bullet(location, right, 10, new SimpleMotion(), theShip);
		
		bullets = new Bullet[2];
		bullets[0] = bullet0;
		bullets[1] = bullet1;
				
		this.setChanged();
		this.notifyObservers();

	}

}

