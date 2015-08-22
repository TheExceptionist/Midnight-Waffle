package com.theexceptionist.main;

import java.awt.Graphics;
import java.util.ArrayList;

import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.WoodTile;

public class Handler {
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private ArrayList<WoodTile> wood = new ArrayList<WoodTile>();
	
	public Handler(){
		
	}
	
	public void tick(){
		for(GameObject o : objects){
			o.tick();
		}
	}
	
	public void render(Graphics g){
		for(WoodTile o : wood){
			o.render(g);
		}
		for(GameObject o : objects){
			o.render(g);
		}
	}
	
	public void addObject(GameObject o){
		objects.add(o);
	}
	
	public void removeObject(GameObject o){
		objects.remove(o);
	}
	
	public void addTile(WoodTile o){
		wood.add(o);
	}
	
	public void removeTile(WoodTile o){
		wood.remove(o);
	}
}
