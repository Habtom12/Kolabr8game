package koala;

import java.awt.Point;

import koala.game.Bullet;
import koala.game.Tank;
import koala.modifiers.firearms.AbstractFireArm;

public class TankWeapon extends AbstractFireArm {
	public TankWeapon(){
		super(KoalaGame.getInstance());
	}
	
	public void fireWeapon(Tank theTank) {
		super.fireWeapon(theTank);
		Point location = theTank.getLocationPoint();
		Point offset = theTank.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		Point speed = new Point(0,-15*direction);
		int strength = 10;
		reload = 15;
		
		TankShot bullet = new TankShot(location, speed, strength, (Koala) theTank);
		bullets = new Bullet[1];
		bullets[0] = bullet;
				
		this.setChanged();
		
		this.notifyObservers();
	}
}