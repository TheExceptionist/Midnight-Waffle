package com.theexceptionist.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.WoodTile;
import com.theexceptionist.gameobject.mob.Enemy;
import com.theexceptionist.sfx.SplashText;

public class Handler {
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	public LinkedList<SplashText> text = new LinkedList<SplashText>();
	private ArrayList<WoodTile> wood = new ArrayList<WoodTile>();
	
	public Handler(){
		
	}
	
	public void tick(){
		for(int i = 0; i < objects.size(); i++){
			GameObject tempObject = objects.get(i);
			
			tempObject.tick();
		}
		for(int i = 0; i < text.size(); i++){
			SplashText tempObject = text.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(WoodTile w : wood){
			w.render(g);
		}
		for(int i = 0; i < text.size(); i++){
			SplashText tempObject = text.get(i);
			
			tempObject.render(g);
		}
		for(int i = 0; i < objects.size(); i++){
			GameObject tempObject = objects.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject o){
		objects.add(o);
	}
	
	public void removeObject(GameObject o){
		objects.remove(o);
		if(o instanceof Enemy){
			GameMain.waveCount++;
		}
	}
	
	public void removeText(SplashText t){
		text.remove(t);
	}
	
	public void addText(SplashText t){
		text.add(t);
	}
	
	public void addTile(WoodTile o){
		wood.add(o);
	}
	
	public void removeTile(WoodTile o){
		wood.remove(o);
	}
}
