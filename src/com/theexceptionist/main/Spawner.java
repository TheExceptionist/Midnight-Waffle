package com.theexceptionist.main;

import java.util.Random;

import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.Table;
import com.theexceptionist.gameobject.mob.EnemyRunner;
import com.theexceptionist.gameobject.mob.Mark;

public class Spawner {
	private Handler h;
	private Random r;
	private int spawnTime = 0;
	private int spawnLim;
	
	public Spawner(Handler h){
		this.h = h;
		r = new Random(System.nanoTime());
		spawnLim = r.nextInt(25) + 25;
	}
	
	public void tick(){
		spawnTime++;
		if(spawnTime >= spawnLim){
			h.addObject(new EnemyRunner("Nerd Runner", r.nextInt(250), -10, 16, 16, h));
			if(GameMain.gameMarks < GameMain.numMarks){
				for(int i = 0; i < h.objects.size(); i++){
					GameObject tempObject = h.objects.get(i);
					
					if(tempObject instanceof Table){
						Table t = (Table) tempObject;
						
						if(r.nextInt(100) <= 25 && t.getX() < 256 && t.getY() < 256){
							h.addObject(new Mark("Mark",t.getX(), t.getY(), 16, 16, h));
						}
					}
				}
			}
			spawnLim = r.nextInt(100)+ 50;
			spawnTime = 0;
		}
	}
}
