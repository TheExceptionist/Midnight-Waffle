package com.theexceptionist.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.Player;
import com.theexceptionist.gameobject.WoodTile;

public class Handler {
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private ArrayList<WoodTile> wood = new ArrayList<WoodTile>();
	
	public Handler(){
		
	}
	
	public void tick(){
		for(int i = 0; i < objects.size(); i++){
			GameObject tempObject = objects.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(WoodTile w : wood){
			w.render(g);
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
	}
	
	public void addTile(WoodTile o){
		wood.add(o);
	}
	
	public void removeTile(WoodTile o){
		wood.remove(o);
	}
}
