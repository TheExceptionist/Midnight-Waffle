package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.assets.Audio;
import com.theexceptionist.gameobject.mob.Mark;
import com.theexceptionist.gameobject.mob.Player;
import com.theexceptionist.main.Handler;
import com.theexceptionist.sfx.SplashText;
import com.theexceptionist.sfx.Splat;

public class Waffles extends Entity{
	private int isPlayer;
	private int coolDown = 0;
	
	public Waffles(String name, int x, int y, int w, int h, Handler han, int isPlayer) {
		super(name, x, y, w, h, han);
		this.isPlayer = isPlayer;
	}
	
	public void tick(){
		super.tick();
		if(coolDown > 0){
			coolDown--;
		}
		
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
			if(isPlayer == 0){
				dy = -3;
			}else{
				dy = 3;
			}
			
			if(tempObject != this){
				if(tempObject instanceof Mark && (isPlayer == 1 || isPlayer == 0)){
					if(coolDown <= 0){
						han.addText(new SplashText("Waffle Ready!!!!", tempObject.x, tempObject.y, han));
						Audio.play("gain");
						coolDown = 50;
					}
				}else if(tempObject instanceof Table && isPlayer != 1){
					Table t = (Table) tempObject;
					if(t.getBoundsUp().intersects(getBounds())){
						die();
					}
					if(t.getBoundsDown().intersects(getBounds())){
						die();
					}
				}else{
					if(tempObject.getBounds().intersects(getBounds())){
						if(tempObject instanceof Mob){
							if(tempObject instanceof Player && (isPlayer == 1 || isPlayer == 0)){
								han.addText(new SplashText("Waffle Throw!!", tempObject.x, tempObject.y, han));
							}else if(isPlayer != 2){
								Mob mob = (Mob) tempObject;
								mob.setDamage(1);	
								die();
							}else if((tempObject instanceof Player || tempObject instanceof Mark) && isPlayer == 2){
								Mob mob = (Mob) tempObject;
								mob.setDamage(1);	
								die();
							}
						}
					}
				}
			}
		}
		
		if(y < -40){
			die();
		}
		if(y > 400){
			die();
		}
	}
	
	public void die(){
		han.addObject(new Splat("Splat", x - 10, y - 7, 32, 32, han));
		super.die();
	}

	public void render(Graphics g) {
		g.drawImage(Assets.waffle1, x, y, w, h, null);
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}


}
