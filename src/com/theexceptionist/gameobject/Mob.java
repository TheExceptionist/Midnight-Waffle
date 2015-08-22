package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.main.Handler;

public abstract class Mob extends Entity{
	protected int health;
	
	public Mob(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
	}


	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public void tick() {
		super.tick();
		if(health <= 0){
			die();
		}
	}
}
