package koala;

import java.awt.Point;

import koala.game.MiscObject;
/**
 * Class represent tnt cell
 * @author
 *
 */
public class Tnt extends MiscObject{

	public Tnt(int x, int y){
		super(new Point(x*40, y*40), new Point(0,0), KoalaGame.sprites.get("tnt"));
	}
}
