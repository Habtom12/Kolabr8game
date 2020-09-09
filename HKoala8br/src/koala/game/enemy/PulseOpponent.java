package koala.game.enemy;

import java.awt.Point;

import koala.KoalaWorld;
import koala.game.Tank;
import koala.modifiers.firearms.PulseFireArm;
import koala.modifiers.movement.SimpleFiringMotion;

public class PulseOpponent extends Tank {
	public PulseOpponent(int location){
		this(location, new Point(0,3), 10, 30);
		
		motion = new SimpleFiringMotion(30);
	}
	
	public PulseOpponent(int location, Point speed, int strength, int fireInterval){
		super(location, speed, strength, KoalaWorld.sprites.get("enemy3"));
		this.weapon = new PulseFireArm();
		
		motion = new SimpleFiringMotion(fireInterval);
	}
}
