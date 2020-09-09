package koala;

import java.awt.Point;

import koala.game.MiscObject;

public class BlueExit extends MiscObject{

	public BlueExit(int x, int y){
		super(new Point(x*40, y*40), new Point(0,0), KoalaGame.sprites.get("exit_blue"));
	}
}
