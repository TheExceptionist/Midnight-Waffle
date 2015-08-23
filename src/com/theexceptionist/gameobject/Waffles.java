package com.theexceptionist.gameobject;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.gameobject.mob.Player;
import com.theexceptionist.main.Handler;
import com.theexceptionist.sfx.Splat;

public class Waffles extends Entity{
	private boolean isPlayer;
	
	public Waffles(String name, int x, int y, int w, int h, Handler han, boolean isPlayer) {
		super(name, x, y, w, h, han);
		this.isPlayer = isPlayer;
	}
	
	public void tick(){
		super.tick();
		dy = -3;
		
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
			
			if(tempObject != this){
				if(tempObject instanceof Table){
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
							if(tempObject instanceof Player && isPlayer){
								System.out.println("Waffle Throw");
							}else{
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
