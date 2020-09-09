package koala;

import java.awt.Point;

import koala.game.Bullet;
import koala.game.Tank;
import koala.modifiers.firearms.AbstractFireArm;

public class FancyTankWeapon extends AbstractFireArm {
	public FancyTankWeapon(){
		super(KoalaGame.getInstance());
	}
	
	public void fireWeapon(Tank theTank) {
		super.fireWeapon(theTank);
		Point location = theTank.getLocationPoint();
		Point offset = theTank.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		Point speed = new Point(0,-15*direction);
		int strength = 7;
		reload = 15;
		
		bullets = new Bullet[2];
		bullets[0] = new TankShot(location, speed, strength, -5, (Koala) theTank);
		bullets[1] = new TankShot(location, speed, strength, 5, (Koala) theTank);
		
				
		this.setChanged();
		
		this.notifyObservers();
	}
}
