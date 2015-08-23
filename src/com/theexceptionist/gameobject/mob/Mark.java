package com.theexceptionist.gameobject.mob;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.Mob;
import com.theexceptionist.gameobject.Waffles;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;
import com.theexceptionist.sfx.SplashText;

public class Mark extends Mob{
	private int sec = 0, n, stirs = 0;
	private int wafflesMade = 0;
	private int healthsMade = 0;
	private Random rand;
	
	public Mark(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		GameMain.numMarks++;
		GameMain.gameMarks = GameMain.numMarks;
		health = 3;
		rand = new Random();
	}

	public void render(Graphics g) {
		n++;
		if(n == 10){
			sec++;
			n = 0;
		}
		
		if(sec == 0){
			g.drawImage(Assets.mark1, x, y, null);
		}
		if(sec == 1){
			g.drawImage(Assets.mark2, x, y, null);
		}
		if(sec == 2){
			g.drawImage(Assets.mark2, x, y, null);
			stirs++;
			sec = 0;
		}
	}
	
	public void tick(){
		if(health == 0){
			GameMain.numMarks--;
		}
		super.tick();
		if(stirs == 10 ){
			if(rand.nextInt(2) == 0){
				wafflesMade++;
			}else{
				healthsMade++;
			}
			stirs = 0;
		}
		checkPlayer();
		checkHealth();
	}
	
	public void checkPlayer(){
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
			
			if(tempObject instanceof Player){
				Player p = (Player) tempObject;
				if(p.getPancakes() <= 1){	
					int pWaffles;
					if(wafflesMade > 3){
						p.setWaffles(3);
						wafflesMade -= 3;
						pWaffles = 3;
					}else{
						p.setWaffles(wafflesMade);
						pWaffles = wafflesMade;
						wafflesMade = 0;
					}
					for(int f = 0; f < pWaffles; f++){
						han.addObject(new Waffles("Waffles" ,x, y, 8, 8, han, 1));
					}
				}
			}
		}
	}
	
	public void checkHealth(){
		if(health == 1 && healthsMade >= 1 && healthsMade <= 3){
			setHealth(healthsMade);
		}
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
				
			if(tempObject instanceof Player){
				Player p = (Player) tempObject;
				
				if(p.getHealth() < 3){
					if(healthsMade > 0){
						p.setHealth(1);
						healthsMade -= 1;
						han.addText(new SplashText("Heal You!!!", x, y, han));
					}
				}
			}
		}
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
