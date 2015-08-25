package com.theexceptionist.gameobject.mob;

import java.awt.Graphics;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.Handler;

public class EnemyThrower extends Enemy{
	private Random rand = new Random(System.nanoTime());
	
	public EnemyThrower(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		money = 25;
	}
	
	public void tick(){
		super.tick();
		wanderThrower(false);
		collide();
	}
	
	public void render(Graphics g){
		super.render(g);
		if(sec == 0 && type == 1){
			g.drawImage(Assets.typeC1, x, y, null);
		}
		if(sec == 1 && type == 1){
			g.drawImage(Assets.typeCC1, x, y, null);
		}
		if(sec == 2 && type == 1){
			g.drawImage(Assets.typeCC1, x, y, null);
			sec = 0;
		}
		
		if(sec == 0 && type == 2){
			g.drawImage(Assets.typeC2, x, y, null);
		}
		if(sec == 1 && type == 2){
			g.drawImage(Assets.typeCC2, x, y, null);
		}
		if(sec == 2 && type == 2){
			g.drawImage(Assets.typeCC2, x, y, null);
			sec = 0;
		}
		
		if(sec == 0 && type == 3){
			g.drawImage(Assets.typeC3, x, y, null);
		}
		if(sec == 1 && type == 3){
			g.drawImage(Assets.typeCC3, x, y, null);
		}
		if(sec == 2 && type == 3){
			g.drawImage(Assets.typeCC3, x, y, null);
			sec = 0;
		}
	}
	
	public int getPancakes(){
		return numPancakes;
	}
	
	
	public void setWaffles(int amount){
		numPancakes += amount;
	}
}
