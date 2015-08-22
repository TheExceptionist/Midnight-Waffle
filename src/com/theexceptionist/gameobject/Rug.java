package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.Handler;

public class Rug extends GameObject{
	private Random r;
	private Handler han;
	private int type;
	
	public Rug(String name, int x, int y, int w, int h, Handler han){
		super(name, x, y, w, h, han);
		r = new Random(System.nanoTime());
		
		type = r.nextInt(2);
	}

	
	public void tick() {
	
		
	}

	
	public void render(Graphics g) {
		if(type == 0){
			g.drawImage(Assets.rug1, x, y, null);	
		}
		if(type == 1){
			g.drawImage(Assets.rug2, x, y, null);	
		}
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
