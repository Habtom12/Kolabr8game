package koala.modifiers.firearms;

import java.util.Observer;

import koala.GameWorld;
import koala.KoalaWorld;
import koala.game.Bullet;
import koala.game.PlayerTank;
import koala.game.Tank;
import koala.modifiers.AbstractGameModifier;

/*Weapons are fired by motion controllers on behalf of players or ships
 * They observe motions and are observed by the Game World
 */
public abstract class AbstractFireArm extends AbstractGameModifier {
	protected Bullet[] bullets;
	boolean friendly;
	int lastFired=0, reloadTime;
	protected int direction;
	public int reload = 5;
	
	public AbstractFireArm(){
		this(KoalaWorld.getInstance());
	}
	
	public AbstractFireArm(Observer world){
		super();
		this.addObserver(world);
	}
	
	public void fireWeapon(Tank theShip){
		if(theShip instanceof PlayerTank){
			direction = 1;
		}
		else{
			direction = -1;
		}
	}
	
	/* read is called by Observers when they are notified of a change */
	public void read(Object theObject) {
		GameWorld world = (GameWorld) theObject;
		world.addBullet(bullets);	
	}
	
	public void remove(){
		this.deleteObserver(KoalaWorld.getInstance());
	}
}
