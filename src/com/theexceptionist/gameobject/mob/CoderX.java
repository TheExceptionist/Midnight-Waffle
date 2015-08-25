package com.theexceptionist.gameobject.mob;

import java.awt.Color;
import java.awt.Graphics;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;
import com.theexceptionist.sfx.SplashText;

public class CoderX extends EnemyRunner{
	private Handler han;

	public CoderX(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		type = 1;
		health *= GameMain.wave + 1;
		attack *= GameMain.wave;
		
		
		this.w = 32;
		this.h = 32;
		
		this.han = han;
		
		han.addText(new SplashText(name+" has appeared!!!", x, y, han));
		
		scoreAmount = 500;
		money = 300;
	}
	
	public void tick(){
		dy = 1;
		super.tick();
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
			g.drawImage(Assets.coderx1, x, y, 32, 32, null);
		}
		if(sec == 1 && type == 1){
			g.drawImage(Assets.coderx2, x, y, 32, 32, null);
		}
		if(sec == 2 && type == 1){
			g.drawImage(Assets.coderx3, x, y, 32, 32, null);
		}
		if(sec == 3 && type == 1){
			g.drawImage(Assets.coderx3, x, y, 32, 32, null);
			sec = 0;
		}
		
	}
}
