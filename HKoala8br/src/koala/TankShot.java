package koala;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

import koala.game.Bullet;

public class TankShot extends Bullet {
	public TankShot(Point location, Point speed, int strength, Koala owner){
		this(location, speed, strength, 0,owner);
	}
	
	public TankShot(Point location, Point speed, int strength, int offset, Koala owner){
		super(location, speed, strength, new Simple2DMotion(owner.direction+offset), owner);
		this.setImage(KoalaGame.sprites.get("bullet"));
	}
	
    public void draw(Graphics g, ImageObserver obs) {
    	if(show){
    		g.drawImage(img, location.x, location.y, null);
    	}
    }
}
