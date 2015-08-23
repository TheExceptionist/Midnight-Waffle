package com.theexceptionist.sfx;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.main.Handler;

public class Splat extends GameObject{
	private int aliveTime;
	
	public Splat(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
	}


	public void tick() {
		aliveTime++;
		if(aliveTime >= 20){
			han.removeObject(this);
		}
	}


	public void render(Graphics g) {
		g.drawImage(Assets.splat, x, y, null);
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
