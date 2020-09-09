package koala;

import java.awt.Point;

import koala.game.BackgroundObject;

public class Wall extends BackgroundObject {
	public Wall(int x, int y){
		super(new Point(x*40, y*40), new Point(0,0), KoalaGame.sprites.get("wall"));
	}
	
	public void damage(int damage){
		return;
	}
}
