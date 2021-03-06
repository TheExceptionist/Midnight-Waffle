package com.theexceptionist.main;

import java.util.Random;

import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.Table;
import com.theexceptionist.gameobject.mob.CoderX;
import com.theexceptionist.gameobject.mob.EnemyRunner;
import com.theexceptionist.gameobject.mob.EnemyThief;
import com.theexceptionist.gameobject.mob.EnemyThrower;
import com.theexceptionist.gameobject.mob.EvilMark;
import com.theexceptionist.gameobject.mob.Mark;
import com.theexceptionist.gameobject.mob.MasterElite;
import com.theexceptionist.sfx.SplashText;

public class Spawner {
	private Handler h;
	private Random r;
	private int spawnTime = 0;
	private int spawnLim;
	private int spawnNum;
	private int spawnNumLim = 30;
	
	public Spawner(Handler h){
		this.h = h;
		r = new Random(System.nanoTime());
		spawnLim = r.nextInt(25) + 25;
		spawnNum = r.nextInt(5) + 1;
	}
	
	public void tick(){
		spawnTime++;
		if(spawnTime >= spawnLim && spawnNumLim >= h.enemy.size()){
			for(int n = 0; n < spawnNum; n++){
				if(r.nextInt(100 * GameMain.wave) <= 5 * GameMain.wave){
					 h.addObject(new EnemyThief("Nerd Thief", r.nextInt(625), -10, 16, 16, h));
				}else if(r.nextInt(200 * GameMain.wave) <= 10 * GameMain.wave){
					 h.addObject(new EnemyThrower("Nerd Thrower", r.nextInt(625), -10, 16, 16, h));
				}else{
			        if(r.nextInt(500 * (GameMain.numMarks / GameMain.wave)) <= 10){
			        	if(r.nextInt(2) == 0){
			        		HordeMode();
			        	}else{
			        		if(r.nextInt(100 * GameMain.wave) <= 5 * GameMain.wave){
			        			h.addObject(new EvilMark("EvilMark", r.nextInt(625), -10, 16, 16, h));
							}else if(r.nextInt(200 * GameMain.wave) <= 10 * GameMain.wave){
								h.addObject(new CoderX("Coder X", r.nextInt(625), -10, 16, 16, h));
							}else{
								h.addObject(new MasterElite("MasterElite", r.nextInt(625), -10, 16, 16, h));
							}
			        	}
			        }
			        h.addObject(new EnemyRunner("Nerd Runner", r.nextInt(625), -10, 16, 16, h));
				}
				System.out.println(GameMain.gameMarks+" "+GameMain.numMarks);
				if(GameMain.gameMarks > GameMain.numMarks){
					for(int i = 0; i < h.objects.size(); i++){
						GameObject tempObject = h.objects.get(i);
						
						if(tempObject instanceof Table){
							Table t = (Table) tempObject;
							
							if(r.nextInt(100) <= 25 && t.getX() < 625 && t.getY() < 625){
								h.addObject(new Mark("Mark",t.getX(), t.getY(), 16, 16, h));
								break;
							}
						}
					}
				}
			}
			spawnNum = r.nextInt(6) + 1;
			spawnLim = r.nextInt(100)+ 50;
			spawnTime = 0;
		}
	}
	
	private void HordeMode(){
		h.addText(new SplashText("Horde Incoming!!!!", 200, -10, h));
		int numPeople = r.nextInt(10) + 10;
			
		for(int i = 0; i < numPeople; i++){
		if(r.nextInt(100 * GameMain.wave) <= 5 * GameMain.wave){
			    h.addObject(new EnemyThief("Nerd Thief", r.nextInt(625), -10, 16, 16, h));
		}else if(r.nextInt(200 * GameMain.wave) <= 10 * GameMain.wave){
			    h.addObject(new EnemyThrower("Nerd Thrower", r.nextInt(625), -10, 16, 16, h));
		}else{
	       if(r.nextInt(500) <= 10 * GameMain.waveCount){
			        HordeMode();
		    }
			    h.addObject(new EnemyRunner("Nerd Runner", r.nextInt(625), -10, 16, 16, h));
			}
		}
	}
}
