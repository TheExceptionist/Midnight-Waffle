package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.Handler;

public class Player extends Mob{
	boolean isThrowing = false;
	
	public Player(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		health = 3;
		System.out.println("Player Spawned");
	}

	public void render(Graphics g) {
		if(!isThrowing){
			g.drawImage(Assets.player1, x, y, null);
		}
		//System.out.println("OP");
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
	
	public void tick(){
		super.tick();
	}
}
