package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.main.Handler;

public abstract class Mob extends Entity{
	protected int health;
	protected boolean isCollidingR = false;
	protected boolean isCollidingL = false;
	protected boolean isCollidingB = false;
	protected boolean isCollidingT = false;
	
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
			}
		}
	}
	
	public void setDamage(int damage){
		health -= damage;
	}
}
