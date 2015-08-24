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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
	
}
