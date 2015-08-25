package com.theexceptionist.gameobject.mob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.Handler;
import com.theexceptionist.sfx.SplashText;

public class MasterElite extends Enemy{

	public MasterElite(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		type = 1;
		health *= 2;
		attack *= 2;
		
		this.w = 36;
		this.h = 36;
		
		han.addText(new SplashText(name+" has appeared!!!", x, y, han));
		
		scoreAmount = 350;
		money = 150;
	}

	public void tick(){
		super.tick();
		wanderThrower(true);
		collide();
		collideThief();
	}
	
	public void render(Graphics g){
		if(isElite){
			g.setColor(Color.BLUE);
			g.drawString("Elite "+name, x, y);
		}else{
			g.setColor(Color.BLUE);
			g.drawString(name, x, y);
		}
		
		if(sec == 0 && type == 1){
			g.drawImage(Assets.melite1, x, y, 36, 36, null);
		}
		if(sec == 1 && type == 1){
			g.drawImage(Assets.melite2, x, y, 36, 36, null);
		}
		if(sec == 2 && type == 1){
			g.drawImage(Assets.melite2, x, y, 36, 36, null);
			sec = 0;
		}
	}
}

