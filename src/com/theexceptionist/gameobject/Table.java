package com.theexceptionist.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.Handler;

public class Table extends GameObject{
	private Random r;
	private Handler han;
	private int type;
	private int health;
	
	public Table(String name, int x, int y, int w, int h, Handler han){
		super(name, x, y, w, h, han);
		r = new Random(System.nanoTime());
		
		type = r.nextInt(2);
		health = r.nextInt(3) + 1;
	}


	public void tick() {
		
	}


	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(x + 5, y + 3, 5, h - 5);
		//g.drawRect(x + 22, y + 3, 5, h - 5);
		g.drawRect(x + 6, y, w - 13, h - 20);
		//g.drawRect(x, y, w, h);
		if(type == 0){
			g.drawImage(Assets.table1, x, y, null);	
		}
		if(type == 1){
			g.drawImage(Assets.table2, x, y, null);	
		}
	}

	public Rectangle getBounds() {
		if(type == 0){
			return new Rectangle(x + 5, y + 3, 5, h - 5);
		}else{
			return new Rectangle(x + 9, y + 7, 5, h - 15);
		}
	}
	
	public Rectangle getBoundsRight() {
		if(type == 0){
			return new Rectangle(x + 22, y + 3, 5, h - 5);
		}else{
			return new Rectangle(x + 9, y + 7, 5, h - 15);
		}
	}
	
	public Rectangle getBoundsUp() {
		if(type == 0){
			return new Rectangle(x + 6, y, w - 13, h - 20);
		}else{
			return new Rectangle(x + 9, y + 7, 5, h - 15);
		}
	}
	//
	public Rectangle getBoundsDown() {
		if(type == 0){
			return new Rectangle(x + 5, y + 3, 5, h - 5);
		}else{
			return new Rectangle(x + 9, y + 7, 5, h - 15);
		}
	}
}
