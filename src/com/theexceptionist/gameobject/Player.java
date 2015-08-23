package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.input.InputHandler;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;

public class Player extends Mob{
	private InputHandler i;
	private boolean isThrowing = false;
	private int tickCount;
	
	public Player(String name, int x, int y, int w, int h, Handler han, InputHandler i) {
		super(name, x, y, w, h, han);
		this.i = i;
		
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
		
		x = GameMain.clamp(x, 0, 250);

		tickCount++;
		if(tickCount >= 2){
			if(i.left.down && !isCollidingR){
				dx = -3;
			}
			else if(i.right.down && !isCollidingL){
				dx = 3;
			}else{
				dx = 0;
			}
			tickCount = 0;
		}
	}
}
