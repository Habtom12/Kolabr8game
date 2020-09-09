package koala.game;

import java.awt.Point;
import java.util.Observable;

import koala.KoalaWorld;
import koala.modifiers.AbstractGameModifier;
import koala.modifiers.firearms.AbstractFireArm;
import koala.modifiers.movement.SimpleMotion;

/* PowerUp extends ship so that it can hold a weapon to give to player*/
public class GainLife extends Tank {
	public GainLife(Tank theShip){
		super(theShip.getLocationPoint(), theShip.getSpeed(), 1, KoalaWorld.sprites.get("powerup"));
		this.motion = new SimpleMotion();
		this.motion.addObserver(this);
		this.weapon = theShip.getWeapon();
	}
	
	public GainLife(int location, int health, AbstractFireArm weapon){
		this(new Point(location, -100), health, weapon);
		this.motion = new SimpleMotion();
		this.motion.addObserver(this);
		this.weapon = weapon;
	}
	
	public GainLife(Point location, int health, AbstractFireArm weapon){
		super(new Point(location),new Point(0,2), health, KoalaWorld.sprites.get("powerup"));
		this.motion = new SimpleMotion();
		this.motion.addObserver(this);
		this.weapon = weapon;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		AbstractGameModifier modifier = (AbstractGameModifier) o;
		modifier.read(this);
	}
	
	public void die(){
    	this.show=false;
    	weapon.deleteObserver(this);
    	motion.deleteObserver(this);
    	KoalaWorld.getInstance().removeClockObserver(motion);
	}

}
