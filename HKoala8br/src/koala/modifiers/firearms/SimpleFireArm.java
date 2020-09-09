package koala.modifiers.firearms;

import java.awt.Point;

import koala.game.Bullet;
import koala.game.Tank;
import koala.modifiers.movement.SimpleMotion;


public class SimpleFireArm extends AbstractFireArm {
	int strength;
	
	public SimpleFireArm(){
		this(5,10);
	}
	
	public SimpleFireArm(int reload){
		this(5,reload);
	}
	
	public SimpleFireArm(int strength, int reload){
		super();
		this.reload = reload;
		this.strength = strength;
	}
	
	@Override
	public void fireWeapon(Tank theShip) {
		super.fireWeapon(theShip);
		Point location = theShip.getLocationPoint();
		Point offset = theShip.getGunLocation();
		location.x+=offset.x;
		location.y+=offset.y;
		Point speed = new Point(0,-15*direction);
		
		Bullet bullet = new Bullet(location, speed, strength, new SimpleMotion(), theShip);
		bullets = new Bullet[1];
		bullets[0] = bullet;
				
		this.setChanged();
		
		this.notifyObservers();
	}

}
