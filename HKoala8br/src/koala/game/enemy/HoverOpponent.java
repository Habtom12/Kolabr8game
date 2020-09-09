package koala.game.enemy;

import java.awt.Point;

import koala.KoalaWorld;
import koala.game.Tank;
import koala.modifiers.firearms.SpreadFireArm;
import koala.modifiers.movement.CentralHorizontalHover;

public class HoverOpponent extends Tank {
	public HoverOpponent(int location){
		this(location, new Point(3,3));
	}
	
	public HoverOpponent(int location, Point speed){
		super(location, speed, 20, KoalaWorld.sprites.get("enemy3"));
		strength=10;
		health=10;
		this.weapon = new SpreadFireArm();
		
		motion = new CentralHorizontalHover();
	}
}
