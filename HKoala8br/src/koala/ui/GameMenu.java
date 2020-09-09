package koala.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Observable;

import koala.KoalaWorld;
import koala.game.PlayerTank;
import koala.modifiers.AbstractGameModifier;
import koala.modifiers.movement.MenuController;

public class GameMenu extends InterfaceObject {
	int selection;
	MenuController controller;
	boolean waiting;
	
	public GameMenu(){
		selection = 0;
		controller = new MenuController(this);
		waiting = true;
	}
	public void draw(Graphics g2, int x, int y){
		g2.setFont(new Font("Calibri", Font.PLAIN, 24));
		if(selection==0)
			g2.setColor(Color.RED);
		else
			g2.setColor(Color.WHITE);
		g2.drawString("1 Player", 200,150);
		if(selection==1)
			g2.setColor(Color.RED);
		else
			g2.setColor(Color.WHITE);
		g2.drawString("2 Player", 200, 250);
		if(selection==2)
			g2.setColor(Color.RED);
		else
			g2.setColor(Color.WHITE);
		g2.drawString("Quit", 200, 350);
	}
	
	public void down(){
		if(selection<2)
			selection++;
	}
	
	public void up(){
		if(selection>0)
			selection--;
	}
	
	public void applySelection(){
		KoalaWorld world = KoalaWorld.getInstance();
		Dimension size = world.getSize();
		
	}
	
	public void update(Observable o, Object arg) {
		AbstractGameModifier modifier = (AbstractGameModifier) o;
		modifier.read(this);
	}
	
	public boolean isWaiting(){
		return this.waiting;
	}
}
