package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.Handler;

public class WoodTile {
	private Random r;
	private Handler h;
	private int type;
	private int x, y;
	
	public WoodTile(int y, int x, Handler h){
		this.h = h;
		this.x = x;
		this.y = y;
		
		r = new Random(System.nanoTime());
		
		type = r.nextInt(3);
	}
	
	public void render(Graphics g){
		if(type == 0){
			g.drawImage(Assets.wood1, x, y, null);
		}
		if(type == 1){
			g.drawImage(Assets.wood2, x, y, null);
		}
		if(type == 2){
			g.drawImage(Assets.wood3, x, y, null);
		}
	}
}
