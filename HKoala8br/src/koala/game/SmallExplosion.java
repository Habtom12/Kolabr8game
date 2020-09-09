package koala.game;

import java.awt.Image;
import java.awt.Point;

import koala.GameSounds;
import koala.KoalaWorld;

/* Small explosions happen whenever an enemy dies */
public class SmallExplosion extends BackgroundObject {
	int timer;
	int frame;
	static Image animation[] = new Image[] {KoalaWorld.sprites.get("explosion1_1"),
		KoalaWorld.sprites.get("explosion1_2"),
		KoalaWorld.sprites.get("explosion1_3"),
		KoalaWorld.sprites.get("explosion1_4"),
		KoalaWorld.sprites.get("explosion1_5"),
		KoalaWorld.sprites.get("explosion1_6"),
		KoalaWorld.sprites.get("explosion1_7")};
	
	public SmallExplosion(Point location) {
		super(location, animation[0]);
		timer = 0;
		frame=0;
		GameSounds.play("Resources/snd_explosion2.wav");
	}
	
	public void update(int w, int h){
    	super.update(w, h);
    	timer++;
    	if(timer%5==0){
    		frame++;
    		if(frame<6)
    			this.img = animation[frame];
    		else
    			this.show = false;
    	}

	}
	
	public boolean collision(GameObject otherObject){
		return false;
	}
}
