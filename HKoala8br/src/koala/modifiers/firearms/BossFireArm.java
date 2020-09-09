package koala.modifiers.firearms;

import java.awt.Point;

import koala.game.Bullet;
import koala.game.Tank;
import koala.modifiers.movement.SimpleMotion;

public class BossFireArm extends AbstractFireArm{
	int pattern = 0;
	public Bullet[] firingPattern0(Tank theShip){
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		return new Bullet[] {
				new Bullet(location, new Point(5,5), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(-5,5), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(-4,5), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(4,5), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(1,5), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(-1,5), 5, new SimpleMotion(), theShip),
			};
	}
	
	public Bullet[] firingPattern1(Tank theShip){
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		return new Bullet[] {
				new Bullet(location, new Point(-12,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(-10,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(-8,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(-6,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(-4,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(-2,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(0,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(2,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(4,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(6,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(8,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(10,6), 5, new SimpleMotion(), theShip),
				new Bullet(location, new Point(12,6), 5, new SimpleMotion(), theShip)
			};
	}
	
	
	public Bullet[] firingPattern2(Tank theShip){
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		return new Bullet[] {
				new Bullet(location, new Point(-12,6), 5, new SimpleMotion(), theShip)
			};
	}
	
	public Bullet[] firingPattern3(Tank theShip){
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		return new Bullet[] {
				new Bullet(location, new Point(-6,6), 5, new SimpleMotion(), theShip)
			};
	}
	
	public Bullet[] firingPattern4(Tank theShip){
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		return new Bullet[] {
				new Bullet(location, new Point(0,12), 5, new SimpleMotion(), theShip)
			};
	}
	
	public Bullet[] firingPattern5(Tank theShip){
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		return new Bullet[] {
				new Bullet(location, new Point(6,6), 5, new SimpleMotion(), theShip)
			};
	}
	
	public Bullet[] firingPattern6(Tank theShip){
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		return new Bullet[] {
				new Bullet(location, new Point(12,6), 5, new SimpleMotion(), theShip)
			};
	}
	
	public void fireWeapon(Tank theShip) {
		super.fireWeapon(theShip);
		switch(pattern){
			case 0:
				bullets = firingPattern0(theShip);
				break;
			case 1:
				bullets = firingPattern1(theShip);
				break;
			case 2:
				bullets = firingPattern2(theShip);
				break;
			case 3:
				bullets = firingPattern3(theShip);
				break;
			case 4:
				bullets = firingPattern4(theShip);
				break;
			case 5:
				bullets = firingPattern5(theShip);
				break;
			case 6:
				bullets = firingPattern6(theShip);
				break;
		}
		if(pattern<6) pattern++;
		else pattern = 0;

		
				
		this.setChanged();
		this.notifyObservers();

	}
}
