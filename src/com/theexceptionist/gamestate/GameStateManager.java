package com.theexceptionist.gamestate;

import java.awt.Graphics;

public class GameStateManager {
	private GameState[] gamestates;
	private int currentState = 2;
	
	private int StartID = 0;
	private int MenuID = 1;
	private int LevelID = 2;
	
	private int numStates = 3;
	
	public GameStateManager(){
		gamestates = new GameState[numStates];
		loadState(currentState);
		
	}
	
	private void loadState(int state){
		if(state == StartID){
			
		}
		if(state == MenuID){
			
		}	
		if(state == LevelID){
			gamestates[state] = new LevelState(this);
		}
	}
	
	private void unLoadState(int state){
		gamestates[state] = null;
	}
	
	public void setState(int state){
		unLoadState(currentState);
		currentState = state;
		loadState(currentState);
	}
	
	public void update(){
		if(gamestates[currentState] != null) gamestates[currentState].update();
	}
	
	public void draw(Graphics g){
		if(gamestates[currentState] != null) gamestates[currentState].draw(g);
	}
}
