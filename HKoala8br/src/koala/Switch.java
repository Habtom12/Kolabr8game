package koala;

import java.awt.Point;

import koala.game.MiscObject;

public class Switch extends MiscObject{

	public Switch(int x, int y){
		super(new Point(x*40, y*40), new Point(0,0), KoalaGame.sprites.get("switch_blue"));
	}
	
}


