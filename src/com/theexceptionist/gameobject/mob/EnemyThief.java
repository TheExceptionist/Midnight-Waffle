package com.theexceptionist.gameobject.mob;

import java.awt.Graphics;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.Handler;

public class EnemyThief extends Enemy{
	private Random rand = new Random(System.nanoTime());
	
	public EnemyThief(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		money = 25;
	}
	
	public void tick(){
		super.tick();
		wanderThief();
		collideThief();
	}
	
	public void render(Graphics g){
		super.render(g);
		if(sec == 0 && type == 1){
			g.drawImage(Assets.typeB1, x, y, null);
		}
		if(sec == 1 && type == 1){
			g.drawImage(Assets.typeBB1, x, y, null);
		}
		if(sec == 2 && type == 1){
			g.drawImage(Assets.typeBB1, x, y, null);
			sec = 0;
		}
		
		if(sec == 0 && type == 2){
			g.drawImage(Assets.typeB2, x, y, null);
		}
		if(sec == 1 && type == 2){
			g.drawImage(Assets.typeBB2, x, y, null);
		}
		if(sec == 2 && type == 2){
			g.drawImage(Assets.typeBB2, x, y, null);
			sec = 0;
		}
		
		if(sec == 0 && type == 3){
			g.drawImage(Assets.typeB3, x, y, null);
		}
		if(sec == 1 && type == 3){
			g.drawImage(Assets.typeBB3, x, y, null);
		}
		if(sec == 2 && type == 3){
			g.drawImage(Assets.typeBB3, x, y, null);
			sec = 0;
		}
	}
}
