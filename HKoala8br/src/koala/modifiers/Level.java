package koala.modifiers;

import java.awt.Point;

import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import koala.KoalaWorld;
import koala.game.*;
import koala.game.enemy.Bomber;
import koala.game.enemy.Boss;
import koala.game.enemy.HoverOpponent;
import koala.game.enemy.PulseOpponent;
import koala.game.enemy.SimpleOpponent;
import koala.modifiers.firearms.SpreadFireArm;

/*This is where enemies are introduced into the game according to a timeline*/
public class Level extends AbstractGameModifier implements Observer {
	int start, lastSpawn, lastPowerUp;
	Integer position;
	Random generator = new Random();
	Tank[] enemyBuffer;
	LinkedHashMap<Integer,Tank[]> timeline;
	int w, h;
	int endgameDelay = 100;	// don't immediately end on game end
	
	/*Constructor sets up arrays of enemies in a LinkedHashMap*/
	public Level(int w, int h){
		super();
		this.w = w;
		this.h = h;
		timeline = new LinkedHashMap<Integer,Tank[]>();
	}
	
	public void load(){
		start = KoalaWorld.getInstance().getTime();
		lastSpawn = KoalaWorld.getInstance().getTime();
		lastPowerUp = KoalaWorld.getInstance().getTime();
		position = new Integer(0);
		
		int playerMultiplier = KoalaWorld.getInstance().countPlayers();
		int enemyStrength = 5*playerMultiplier;
		
        Tank[] wave = new Tank[]{
    			
    	};
		timeline.put(new Integer(0), wave);
		
        wave = new Tank[]{
    	};
		timeline.put(new Integer(1), wave);
		
    	wave = new Tank[]{
    			new Bomber(200,8, 50),
    			new PulseOpponent(-10,new Point(6,1), 20, 60),
    			new Bomber(400, 4, 30),
    			new Bomber(600, 6, 40)
    	};
    	timeline.put(new Integer(2), wave);
    	
    	for(int i=3;i<9;i+=3){
        	wave = new Tank[]{
        	};
        	
        	timeline.put(new Integer(i), wave);
        	
        	wave = new Tank[]{
        	};
        	timeline.put(new Integer(i+1), wave);
        	
        	wave = new Tank[]{
        	};
        	timeline.put(new Integer(i+2), wave);
        	
    	}
    	    	
    	wave = new Tank[]{
    			new Boss(new Point(w/2,-100), new Point(3,3), enemyStrength*80)
    	};
    	
    	timeline.put(new Integer(timeline.size()+1), wave);
	}
	
	public void read(Object theObject){
	}

	/*Level observes GameClock and updates on every tick*/
	@Override
	public void update(Observable o, Object arg) {
		KoalaWorld world = KoalaWorld.getInstance();
        if(world.countEnemies()<3){
        	Tank[] enemies = timeline.remove(position);
        	if(enemies!=null){
        		world.addEnemies(enemies);
	        	setChanged();
	        	notifyObservers();
        	}
        	position +=1;
        }
        
        if(world.getTime() - lastSpawn > 7000){
        	Tank[] wave = {
        			new SimpleOpponent(100, new Point(1,4), 10, 45),
        			new SimpleOpponent(200, new Point(1,5), 10, 30),
        			new SimpleOpponent(300, new Point(1,4), 15, 60),
        			new SimpleOpponent(500, new Point(-2,5), 10, 40),
        			new SimpleOpponent(600, new Point(2,6), 10, 30),
        			new SimpleOpponent(700, new Point(-2,5), 10, 70),
        			new PulseOpponent(500)
        	};
        	world.addEnemies(wave);
        	lastSpawn = world.getTime();
        }
        
        if(world.getTime() - lastPowerUp > 30000){
        	world.addRandomPowerUp();
        	lastPowerUp=world.getTime();
        }
        
        
		if(world.isGameOver()){
			if(endgameDelay<=0){
				KoalaWorld.getInstance().removeClockObserver(this);
				KoalaWorld.getInstance().finishGame();
			} else endgameDelay--;
		}
	}
}
