package com.theexceptionist.sfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.theexceptionist.main.Handler;

public class SplashText {
	private String message;
	private int x, y, dy, dx;
	private Font f;
	private int aliveTime;
	private int aliveLim;
	private Handler han;
	
	public SplashText(String message, int x, int y, Handler han){
		this.message = message;
		this.x = x;
		this.y = y;
		this.han = han;
		f = new Font("Arial", Font.PLAIN, 8);
		aliveLim = 100;
	}
	
	public void tick(){
		aliveTime++;
		
		x += dx;
		y += dy;
		
		dy = 3;
		
		if(aliveTime >= aliveLim){
			han.removeText(this);
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.ORANGE);
		g.setFont(f);
		g.drawString(message, x, y);
	}
}
