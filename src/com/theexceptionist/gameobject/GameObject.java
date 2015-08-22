package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected String name; 
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	
	public GameObject(String name, int x, int y, int w, int h){
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
}
