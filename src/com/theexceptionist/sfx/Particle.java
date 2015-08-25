package com.theexceptionist.sfx;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;

public class Particle extends GameObject{
	private int dx, dy, decay, alive, shouldClamp;
	private Random r = new Random(System.nanoTime());
	
	public Particle(String name, int x, int y, int w, int h, Handler han){
		super(name, x, y, w, h, han);
		dx = r.nextInt(5)+1;
		dy = r.nextInt(5)+1;
		shouldClamp = r.nextInt(2);
		alive = 100;
		
		if(r.nextInt(2) == 0){
			dx *= -1;
		}
		
		if(r.nextInt(2) == 0){
			dy *= -1;
		}
	}
	
	public void tick(){
		x += dx--;
		y += dy--;
		
		//if(shouldClamp == 0){
			dx = GameMain.clamp(dx, 0, 10);
			dy = GameMain.clamp(dy, 0, 10);
		//}
		
		if(alive < 0){
			han.removeObject(this);
		}
		alive--;
	}
	
	public void render(Graphics g){
		g.drawImage(Assets.waffleP, x, y, null);
		//System.out.println(this+""+x+" "+y);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
