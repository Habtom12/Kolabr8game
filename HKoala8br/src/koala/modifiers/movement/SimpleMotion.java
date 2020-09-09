package koala.modifiers.movement;

import koala.game.*;

public class SimpleMotion extends MotionController {
	
	public SimpleMotion() {
		super();
	}
	
	public void read(Object theObject){
		MoveableObject object = (MoveableObject) theObject;
		object.move();
	}
}
