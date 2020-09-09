package koala.game.enemy;

import java.awt.Point;

import koala.KoalaWorld;
import koala.game.Tank;
import koala.modifiers.firearms.SpreadBomb;
import koala.modifiers.movement.SimpleFiringMotion;

public class Bomber extends Tank {
	public Bomber(int location){
		this(location, 30, 6);
	}
	
	public Bomber(int location, int speed, int interval){
		super(location, new Point(0,speed), 100, KoalaWorld.sprites.get("enemy3"));
		this.weapon = new SpreadBomb();
		
		motion = new SimpleFiringMotion(interval);
	}

}
