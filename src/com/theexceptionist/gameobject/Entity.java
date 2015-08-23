package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.main.Handler;

public abstract class Entity extends GameObject{
	protected int dx;
	protected int dy;

	public Entity(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
	}
	
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void tick(){
		x += dx;
		y += dy;
	}
	
	protected void die(){
		han.removeObject(this);
	}
}
