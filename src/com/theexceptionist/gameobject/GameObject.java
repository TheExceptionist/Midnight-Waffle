package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.main.Handler;

public abstract class GameObject {
	protected String name; 
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected Handler han;
	
	public GameObject(String name, int x, int y, int w, int h, Handler han){
		this.name = name;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.han = han;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
}
