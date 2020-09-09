package koala.game.enemy;

import java.awt.Point;

import koala.KoalaWorld;
import koala.game.Tank;
import koala.modifiers.firearms.BossFireArm;
import koala.modifiers.movement.CentralHorizontalHover;

public class Boss extends Tank {

	
	public Boss(Point location, Point speed, int strength){
		super(location, speed, strength, KoalaWorld.sprites.get("boss"));
		this.weapon = new BossFireArm();
		this.gunLocation = new Point(41,54);
		
		motion = new CentralHorizontalHover(30, 50);
	}
	
	// end the game when we kill the boss
	public void die(){
		super.die();
		KoalaWorld.getInstance().endGame(true);
	}
}
