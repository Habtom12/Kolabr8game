package koala;

import koala.game.MoveableObject;
import koala.modifiers.movement.MotionController;

public class Simple2DMotion extends MotionController {
	int dx,dy;
	public Simple2DMotion(int direction) {
		super(KoalaGame.getInstance());
    	dy = (int)(10*(double)Math.cos(Math.toRadians(direction+90)));
    	dx = (int)(10*(double)Math.sin(Math.toRadians(direction+90)));
    }
	
	public void read(Object theObject){
		MoveableObject object = (MoveableObject) theObject;
		object.move(dx, dy);
	}
}
