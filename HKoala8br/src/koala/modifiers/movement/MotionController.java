package koala.modifiers.movement;

import java.util.Observable;
import java.util.Observer;

import koala.GameWorld;
import koala.KoalaWorld;
import koala.game.*;
import koala.modifiers.AbstractGameModifier;

/*MotionControllers move around objects!*/
public abstract class MotionController extends AbstractGameModifier implements Observer {
	int fireInterval;
	
	public MotionController(){
		this(KoalaWorld.getInstance());
		fireInterval = -1;
	}
	
	public MotionController(GameWorld world){
		world.addClockObserver(this);
	}
	
	public void delete(Observer theObject){
		KoalaWorld.getInstance().removeClockObserver(this);
		this.deleteObserver(theObject);
	}
	
	/*Motion Controllers observe the GameClock and fire on every clock tick
	 * The default controller doesn't do anything though*/
	public void update(Observable o, Object arg){
		this.setChanged();
		this.notifyObservers();
	}
	
	public void read(Object theObject){
		Tank object = (Tank) theObject;
		object.move();
		
		if(KoalaWorld.getInstance().getFrameNumber()%fireInterval==0){
			object.fire();
		}
	}
}
