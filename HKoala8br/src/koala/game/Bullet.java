package koala.game;

import java.awt.Point;

import koala.KoalaWorld;
import koala.modifiers.movement.MotionController;

/*Bullets fired by player and enemy weapons*/
public class Bullet extends MoveableObject {
	protected PlayerTank owner;
	boolean friendly;
	
	public Bullet(Point location, Point speed, int strength, MotionController motion, GameObject owner){
		super(location, speed, KoalaWorld.sprites.get("enemybullet1"));
		this.strength=strength;
		if(owner instanceof PlayerTank){
			this.owner = (PlayerTank) owner;
			this.friendly=true;
			this.setImage(KoalaWorld.sprites.get("bullet"));
		}
		this.motion = motion;
		motion.addObserver(this);
	}
	
	public PlayerTank getOwner(){
		return owner;
	}
	
	public boolean isFriendly(){
		if(friendly){
			return true;
		}
		return false;
	}
}
