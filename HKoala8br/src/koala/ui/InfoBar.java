package koala.ui;

import java.awt.Graphics;

import koala.GameWorld;
import koala.KoalaGame;
import koala.KoalaWorld;
import koala.game.*;

/**
 * Class represent Information bar which holds the information about number of Koala rescued
 * @author
 *
 */
public class InfoBar extends InterfaceObject {
	PlayerTank player;
	String name;
	
	
	public InfoBar(PlayerTank player, String name){
		this.player = player;
		this.name = name;
		
	}
	
	public void draw(Graphics g2, int x, int y){
		g2.drawImage(KoalaGame.sprites.get("rescued"), 0, 0, observer);
		
		for (int i = 0; i < KoalaGame.saved; i++) {
			g2.drawImage(KoalaGame.sprites.get("koala_down_3"), x+140 + i*50, 0, observer);
		}
		
        
	}

}
