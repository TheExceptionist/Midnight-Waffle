package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.theexceptionist.assets.Audio;
import com.theexceptionist.main.Handler;
import com.theexceptionist.sfx.SplashText;

public abstract class Mob extends Entity{
	protected int health;
	protected boolean isCollidingR = false;
	protected boolean isCollidingL = false;
	protected boolean isCollidingU = false;
	protected boolean isCollidingD = false;
	protected int numPancakes;
	private Random rand = new Random(System.nanoTime());
	
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
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
			
			if(tempObject instanceof Table){
				Table table = (Table) tempObject;
				if(tempObject != this && table.getBounds().intersects(getBounds())){
						this.dx = 0;
						isCollidingL = true;
						break;
				}else{
					isCollidingL = false;
				}
				if(tempObject != this && table.getBoundsRight().intersects(getBounds())){
						this.dx = 0;
						isCollidingR = true;
						break;
				}else{
					isCollidingR = false;
				}
				if(tempObject != this && table.getBoundsUp().intersects(getBounds())){
					this.dx = 0;
					isCollidingU = true;
					break;
				}else{
					isCollidingU = false;
				}
				if(tempObject != this && table.getBoundsDown().intersects(getBounds())){
						this.dx = 0;
						isCollidingD = true;
						break;
				}else{
					isCollidingD = false;
				}
			}
		}
	}
	
	public void takeWaffles(int amount){
		int r = rand.nextInt(3);
		if(r == 0){
			Audio.play("hurt1");
		}else if(r == 1){
			Audio.play("hurt2");
		}else{
			Audio.play("hurt3");
		}
	    han.addText(new SplashText(name+" lost Waffles: "+amount, x, y, han));
		numPancakes -= amount;
	}
	
	public void setHealth(int amount){
		  han.addText(new SplashText(name+" got healed: "+amount, x, y, han));
		health += amount;
	}
	
	public void setDamage(int damage){
		int r = rand.nextInt(3);
		if(r == 0){
			Audio.play("hurt1");
		}else if(r == 1){
			Audio.play("hurt2");
		}else{
			Audio.play("hurt3");
		}
	    han.addText(new SplashText(name+" got damaged: "+damage, x, y, han));
		health -= damage;
	}
}
