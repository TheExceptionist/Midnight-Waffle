package com.theexceptionist.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.gameobject.mob.Player;

public class HUD {
	private Player p;
	private Font f;
	
	public HUD(Player p){
		this.p = p;
		f = new Font("Arial", Font.BOLD ,10);
	}
	
	public void render(Graphics g){
		g.setFont(f);
		g.setColor(Color.GREEN);

		for(int i = 0; i < p.getHealth(); i++){
			g.drawImage(Assets.heart1, 130 + 20 * i, -5, null);
		}
		
		for(int i = 0; i < p.getPancakes(); i++){
			g.drawImage(Assets.waffle1, 490 + 34 * i, 0, null);
		}
		
		g.drawString("Health: ", 100, 10);
		g.drawString("Money: "+p.getMoney(), 7, 10);
		g.drawString("Score: "+p.getScore(), 230, 10);
		g.drawString("Pancakes: ", 430, 10);
		g.drawString("Wave: "+GameMain.wave, 595, 10);
		
		if(GameMain.lose){
			g.setFont(new Font("Arial", Font.BOLD ,25));
			g.drawString("Game Over!!!!!", 230, 180);
			g.setFont(new Font("Arial", Font.BOLD , 5));
			g.drawString("Press enter to try again, press esc to go to the main menu.", 240, 200);
		}
	}
}
