package com.theexceptionist.gameobject.mob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.assets.Audio;
import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.Mob;
import com.theexceptionist.gameobject.Waffles;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;
import com.theexceptionist.sfx.SplashText;

public class EvilMark extends Enemy{
	private int sec = 0, n, stirs = 0, stirLim;
	private int wafflesMade = 0;
	private int healthsMade = 0;
	private Random rand;
	
	public EvilMark(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		health = 6;
		rand = new Random();
		stirLim = rand.nextInt(10)+10;
		
		han.addText(new SplashText(name+" has appeared!!!", x, y, han));
		
		scoreAmount = 200;
		money = 100;
	}

	public void render(Graphics g) {
		if(isElite){
			g.setColor(Color.BLUE);
			g.drawString("Elite "+name, x, y);
		}else{
			g.setColor(Color.BLUE);
			g.drawString(name, x, y);
		}
		
		
		n++;
		if(n == 10){
			sec++;
			n = 0;
		}
		
		if(sec == 0){
			g.drawImage(Assets.emark1, x, y, null);
		}
		if(sec == 1){
			g.drawImage(Assets.emark2, x, y, null);
		}
		if(sec == 2){
			g.drawImage(Assets.emark2, x, y, null);
			stirs++;
			sec = 0;
		}
	}
	
	public void die(){
		super.die();
	}
	
	public void tick(){
		super.tick();
		wanderE();
		if(stirs == stirLim){
				Audio.play("finished");
				han.addText(new SplashText("Heart Finished HEHE!!!!", x, y, han));
				healthsMade++;
			
			stirs = 0;
		}
		checkHealth();
	}
	
	public void checkHealth(){
		if(health == 1 && healthsMade >= 1 && healthsMade <= 3){
			setHealth(healthsMade);
		}
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
				
			if(tempObject instanceof Enemy){
				Enemy p = (Enemy) tempObject;
				
				if(p.getHealth() < 3){
					if(healthsMade > 0){
						p.setHealth(1);
						healthsMade -= 1;
						han.addText(new SplashText("Heal You Enemy!!!", x, y, han));
					}
				}
			}
		}
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
