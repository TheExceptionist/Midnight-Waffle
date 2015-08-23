package com.theexceptionist.gameobject.mob;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.gameobject.Mob;
import com.theexceptionist.gameobject.Waffles;
import com.theexceptionist.input.InputHandler;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;

public class Player extends Mob{
	private InputHandler i;
	private boolean isThrowing = false;
	private int tickCount;
	private int numPancakes;
	private int money;
	private int coolDown;
	
	public Player(String name, int x, int y, int w, int h, Handler han, InputHandler i) {
		super(name, x, y, w, h, han);
		this.i = i;
		
		health = 3;
		numPancakes = 3;
		money = 0;
		coolDown = 0;
		System.out.println("Player Spawned");
	}

	public void render(Graphics g) {
		if(!isThrowing){
			g.drawImage(Assets.player1, x, y, null);
		}
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
		
		if(coolDown == 0){
			if(i.attack.down && numPancakes > 0){
				toss(x, y);
			}
			coolDown = 5;
		}else{
			coolDown--;
		}
		if(numPancakes <= 0){
			numPancakes = 0;
		}
	}
	
	public void setWaffles(int amount){
		numPancakes += amount;
	}
	
	public void toss(int x, int y){
		han.addObject(new Waffles("Waffle", x + 4, y, 8, 8, han, true));
		numPancakes--;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getMoney(){
		return money;
	}
	
	public int getPancakes(){
		return numPancakes;
	}
}
