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
			g.drawImage(Assets.heart1, 33 + 20 * i, 310, null);
		}
		
		for(int i = 0; i < p.getPancakes(); i++){
			g.drawImage(Assets.waffle1, 165 + 34 * i, 310, null);
		}
		
		g.drawString("Health: ", 7, 330);
		g.drawString("Money: "+p.getMoney(), 105, 10);
		g.drawString("Pancakes: ", 110, 330);
	}
}
