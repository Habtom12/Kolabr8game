package koala.game;

import java.awt.Image;
import java.awt.Point;

import koala.KoalaWorld;
import koala.modifiers.firearms.AbstractFireArm;
import koala.modifiers.movement.MotionController;
/**
 * koala are things that have weapons and health 
 * @author 
 *
 */
public class Tank extends MoveableObject {
	protected AbstractFireArm weapon;
	protected int health;
	protected Point gunLocation;
	
    public Tank(Point location, Point speed, int strength, Image img){
    	super(location,speed,img);
    	this.strength=strength;
    	this.health=strength;
    	this.gunLocation = new Point(15,20);
    }
    
    public Tank(int x, Point speed, int strength, Image img){
    	this(new Point(x,-90), speed, strength, img);
    }
    
    public void setWeapon(AbstractFireArm weapon){
    	this.weapon.remove();
    	this.weapon = weapon;
    }
    
    public AbstractFireArm getWeapon(){
    	return this.weapon;
    }
    
    public void damage(int damageDone){
    	this.health -= damageDone;
    	if(health<=0){
    		this.die();
    	}
    	return;
    }
    
    public void die(){
    	this.show=false;
    	SmallExplosion explosion = new SmallExplosion(new Point(location.x,location.y));
    	KoalaWorld.getInstance().addBackground(explosion);
    	weapon.deleteObserver(this);
    	motion.deleteObserver(this);
    	KoalaWorld.getInstance().removeClockObserver(motion);
    }
    
    public void collide(GameObject otherObject){
    }
    
    public void fire()
    {
    	weapon.fireWeapon(this);
    }
    
    /* some setters and getters!*/
    public void setHealth(int health){
    	this.health = health;
    }
    
    public int getHealth(){
    	return health;
    }
    
    public MotionController getMotion(){
    	return this.motion;
    }
    
    public void setMotion(MotionController motion){
    	this.motion = motion;
    }
    
    public Point getGunLocation(){
    	return this.gunLocation;
    }
}