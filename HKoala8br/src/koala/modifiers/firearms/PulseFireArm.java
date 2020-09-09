package koala.modifiers.firearms;

import java.awt.Point;

import koala.game.Bullet;
import koala.game.PlayerTank;
import koala.game.Tank;
import koala.modifiers.movement.SimpleMotion;

public class PulseFireArm extends AbstractFireArm {
	public void fireWeapon(Tank theShip) {
		super.fireWeapon(theShip);
		Point location = theShip.getLocationPoint();
		Point speed = theShip.getSpeed();
		Point offset = theShip.getGunLocation();
		if(theShip instanceof PlayerTank){
			speed.y=-8;
		}
		location.x+=offset.x;
		location.y+=offset.y;
				
		bullets = new Bullet[] {
			new Bullet(location, new Point(3,1+speed.y), 1, new SimpleMotion(), theShip),
			new Bullet(location, new Point(-3,1+speed.y), 1, new SimpleMotion(), theShip),
			new Bullet(location, new Point(2,2+speed.y), 1, new SimpleMotion(), theShip),
			new Bullet(location, new Point(-2,2+speed.y), 1, new SimpleMotion(), theShip),
			new Bullet(location, new Point(1,3+speed.y), 1, new SimpleMotion(), theShip),
			new Bullet(location, new Point(-1,3+speed.y), 1, new SimpleMotion(), theShip),
		};
				
		this.setChanged();
		this.notifyObservers();

	}
}
