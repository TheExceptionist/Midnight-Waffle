package com.theexceptionist.gameobject.mob;

import java.awt.Graphics;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;

public class EnemyRunner extends Enemy{
	private Random rand = new Random(System.nanoTime());
	public EnemyRunner(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		if(rand.nextInt(100) <= 5){
			isElite = true;
		}
		if(isElite){
			health *= 2;
		}
		genType();
	}

	public void tick(){
		super.tick();
		wander();
	}
	
	public void render(Graphics g){
		super.render(g);
		if(sec == 0 && type == 1){
			g.drawImage(Assets.typeA1, x, y, null);
		}
		if(sec == 1 && type == 1){
			g.drawImage(Assets.typeAA1, x, y, null);
		}
		if(sec == 2 && type == 1){
			g.drawImage(Assets.typeAA1, x, y, null);
			sec = 0;
		}
		
		if(sec == 0 && type == 2){
			g.drawImage(Assets.typeA2, x, y, null);
		}
		if(sec == 1 && type == 2){
			g.drawImage(Assets.typeAA2, x, y, null);
		}
		if(sec == 2 && type == 2){
			g.drawImage(Assets.typeAA2, x, y, null);
			sec = 0;
		}
		
		if(sec == 0 && type == 3){
			g.drawImage(Assets.typeA3, x, y, null);
		}
		if(sec == 1 && type == 3){
			g.drawImage(Assets.typeAA3, x, y, null);
		}
		if(sec == 2 && type == 3){
			g.drawImage(Assets.typeAA3, x, y, null);
			sec = 0;
		}
	}

}