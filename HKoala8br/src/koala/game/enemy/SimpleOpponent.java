package koala.game.enemy;

import java.awt.Point;


import koala.KoalaWorld;
import koala.game.Tank;
import koala.modifiers.firearms.NullFireArm;
import koala.modifiers.firearms.SimpleFireArm;
import koala.modifiers.movement.SimpleFiringMotion;
import koala.modifiers.movement.SimpleMotion;

/*A simple enemy that just moves vertically and possibly fires at fixed intervals*/
public class SimpleOpponent extends Tank {
	public SimpleOpponent(int location){
		this(location, new Point(0,3), 5, 0);
	}
	
	public SimpleOpponent(int location, Point speed, int strength, int fireInterval){
		super(location, speed, strength, KoalaWorld.sprites.get("enemy1"));
		
		if(fireInterval==0){
			this.weapon = new NullFireArm();
			motion = new SimpleMotion();
		} else{
			this.weapon = new SimpleFireArm();
			motion = new SimpleFiringMotion(fireInterval);
		}
	}

}
