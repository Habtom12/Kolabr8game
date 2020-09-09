package koala.modifiers.movement;

import koala.KoalaWorld;
import koala.game.Tank;

public class SimpleFiringMotion extends SimpleMotion {
	public SimpleFiringMotion(int interval){
		super();
		this.fireInterval = interval;
	}
	
	public void read(Object theObject){
		super.read(theObject);
		
		Tank ship = (Tank) theObject;
		
		if(KoalaWorld.getInstance().getFrameNumber()%fireInterval==0){
			ship.fire();
		}
	}

}
