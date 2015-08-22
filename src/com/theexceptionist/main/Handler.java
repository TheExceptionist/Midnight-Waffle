package com.theexceptionist.main;

import java.awt.Graphics;
import java.util.ArrayList;

import com.theexceptionist.gameobject.GameObject;

public class Handler {
	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public Handler(){
		
	}
	
	public void tick(){
		for(GameObject o : objects){
			o.tick();
		}
	}
	
	public void render(Graphics g){
		for(GameObject o : objects){
			o.render(g);
		}
	}
}
