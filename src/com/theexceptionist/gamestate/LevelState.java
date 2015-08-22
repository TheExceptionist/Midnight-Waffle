package com.theexceptionist.gamestate;

import java.awt.Color;
import java.awt.Graphics;

import com.theexceptionist.main.GameMain;

public class LevelState extends GameState{
	public LevelState(GameStateManager gsm) {
		super(gsm);
		
	}


	public void init() {
	
		
	}


	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameMain.width, GameMain.height);
	}


	public void update() {
	
		
	}


	public void keyPressed(int k) {
	
		
	}


	public void keyReleased(int k) {
	
		
	}

}
