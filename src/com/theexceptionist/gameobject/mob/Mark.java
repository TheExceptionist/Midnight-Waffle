package com.theexceptionist.gameobject.mob;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.Mob;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;

public class Mark extends Mob{
	private int sec = 0, n, stirs = 0;
	private int wafflesMade = 0;
	
	public Mark(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		GameMain.numMarks++;
		health = 3;
	}

	public void render(Graphics g) {
		n++;
		if(n == 7){
			sec++;
			n = 0;
		}
		
		if(sec == 0){
			g.drawImage(Assets.mark1, x, y, null);
		}
		if(sec == 1){
			g.drawImage(Assets.mark2, x, y, null);
		}
		if(sec == 2){
			g.drawImage(Assets.mark2, x, y, null);
			stirs++;
			sec = 0;
		}
	}
	
	public void tick(){
		super.tick();
		if(stirs == 3){
			wafflesMade++;
			stirs = 0;
		}
	}
	
	public void checkPlayer(){
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
			
			if(tempObject instanceof Player){
				Player p = (Player) tempObject;
				if(p.getPancakes() <= 1){	
					if(wafflesMade > 3){
						p.setWaffles(3);
						wafflesMade -= 3;
					}else{
						p.setWaffles(wafflesMade);
						wafflesMade = 0;
					}
				}
			}
		}
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

}
