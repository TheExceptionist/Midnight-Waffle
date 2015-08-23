package com.theexceptionist.gameobject.mob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.theexceptionist.assets.Audio;
import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.Mob;
import com.theexceptionist.gameobject.Waffles;
import com.theexceptionist.main.GameMain;
import com.theexceptionist.main.Handler;
import com.theexceptionist.sfx.SplashText;

public abstract class Enemy extends Mob{
	protected boolean isElite;
	protected int type;
	
	private Random rand;
	private int turning = 0;
	private int turnLim;
	private int coolDown = 0;
	private int coolDown1 = 0;
	private int attack;
	private int thrown = 0, throwLim;
	private boolean PlayerKill = false;
	private boolean shouldStop = false;
	
	private boolean turnL = false, turnR = false;
	protected int sec = 0;
	protected int n = 0;
	
	public Enemy(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		rand = new Random(System.nanoTime());
		type = rand.nextInt(3);
		health = 1 * type;
		turnLim = 10;
		attack = 1 * type;
		throwLim = rand.nextInt(3)+3;
		
		if(rand.nextInt(100) <= 5){
			isElite = true;
			Audio.play("hackerb1");
			han.addText(new SplashText("Hack Elite Spawned!!!", x, y, han));
		}
		if(isElite){
			health *= 2;
			attack *= 2;
			throwLim *= 2;
		}
	}
	
	protected void genType(){
		if(GameMain.waveCount >= 5 && GameMain.waveCount < 10){
			if(rand.nextInt(20*GameMain.waveCount) <= 5 * GameMain.waveCount){
				type = 2;
			}else{
				type = 1;
			}
		}else if(GameMain.waveCount >= 10){
			if(rand.nextInt(20*GameMain.waveCount) <= 2 * GameMain.waveCount){
				type = 3;
			}else if(rand.nextInt(20*GameMain.waveCount) <= 5 * GameMain.waveCount){
				type = 2;
			}else{
				type = 1;
			}
		}else{
			type = 1;
		}
	}
	

	public void render(Graphics g) {
		if(isElite){
			g.setColor(Color.BLUE);
			g.drawString("Elite", x, y);
		}
	}
	
	public void tick(){
		super.tick();
		n++;
		if(n == 10){
			sec++;
			n = 0;
		}
		
		if(y > 400){
			die();
		}
		if(x < -20){
			die();
		}
		if(x > 400){
			die();
		}
	}
	protected void wander(){
			if(turnL){
				turning++;
				turnLeft();
				if(turning >= turnLim){
					turning = 0;
					turnL = false;
				}
			}else if(turnR){
				turning++;
				turnRight();
				if(turning >= turnLim){
					turning = 0;
					turnR = false;
				}
			}else{
				if(isCollidingU){
					dy = 0;
					if(rand.nextInt(2) == 0){
						turnLeft();
					}else{
						turnRight();
					}
				}else if(rand.nextInt(500) <= 1){
					if(rand.nextInt(2) == 0){
						turnLeft();
					}else{
						turnRight();
					}
				}else{
					forward();
				}
			}
	}
	
	protected void wanderThrower(){
		if(!shouldStop){
			if(turnL){
				turning++;
				turnLeft();
				if(turning >= turnLim){
					turning = 0;
					turnL = false;
				}
			}else if(turnR){
				turning++;
				turnRight();
				if(turning >= turnLim){
					turning = 0;
					turnR = false;
				}
			}else{
				if(isCollidingU){
					dy = 0;
					if(rand.nextInt(2) == 0){
						turnLeft();
					}else{
						turnRight();
					}
				}else if(rand.nextInt(500) <= 1){
					if(rand.nextInt(2) == 0){
						turnLeft();
					}else{
						turnRight();
					}
				}else{
					forward();
				}
			}
		}else{
			dx = 0;
			dy = 0;
			if(coolDown1 == 0){
				aim();
				thrown++;
			}
			if(coolDown1 > 0){
				coolDown1--;
			}
			if(thrown >= throwLim){
				shouldStop = false;
				thrown = 0;
			}
		}
	}
	
	protected void aim(){
		int r = rand.nextInt(4);
		if(r == 0){
			Audio.play("throw1");
		}else if(r == 1){
			Audio.play("throw2");
		}else if(r == 2){
			Audio.play("throw3");
		}else{
			Audio.play("throw4");
		}
		han.addObject(new Waffles("Waffle", x + 4, y, 8, 8, han, 2));
		numPancakes--;
		coolDown1 = 100;
	}
	
	protected void collide(){
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
			
			if(tempObject instanceof Player){
				Player p = (Player) tempObject;
				
				if(p.getBounds().intersects(getBounds()) && coolDown == 0){
					p.setDamage(attack);
					coolDown = 100;
				}
			}
			if(tempObject instanceof Mark){
				Mark m = (Mark) tempObject;
				
				if(m.getBounds().intersects(getBounds()) && coolDown == 0){
					m.setDamage(attack);
					setDamage(1);
					coolDown = 100;
				}
			}
		}
		if(coolDown > 0){
			coolDown--;
		}
	}
	
	protected void collideThief(){
		for(int i = 0; i < han.objects.size(); i++){
			GameObject tempObject = han.objects.get(i);
			
			if(tempObject instanceof Player || tempObject instanceof Mark){
				Mob m = (Mob) tempObject;
				
				if(m.getBounds().intersects(getBounds())){
					m.takeWaffles(attack);
					coolDown = 100;
				}
			}
		}
		if(coolDown > 0){
			coolDown--;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
	
	protected void die(){
		if(PlayerKill){
			for(int i = 0; i < han.objects.size(); i++){
				GameObject tempObject = han.objects.get(i);
				if(tempObject instanceof Player){
					Player p = (Player) tempObject;
					
					if(rand.nextInt(100) <= 20){
						if(rand.nextInt(2) == 0){
							if(p.getHealth() < 3){
								p.setHealth(1);
								han.addText(new SplashText("Health Gained!!!!", x, y, han));
							}
						}else{
							if(p.getPancakes() < 3){
								p.setWaffles(1);
								han.addText(new SplashText("Waffle Gained!!!!", x, y, han));
							}
						}
					}else{
						p.setMoney(rand.nextInt(25*type)+25);
						han.addText(new SplashText("Money Gained!!!!", x, y, han));
					}
				}
			}
		}
		super.die();
	}
	
	public void setDamage(int amount, boolean PlayerHit){
		super.setDamage(amount);
		if(health == 0 && PlayerHit){
			PlayerKill = true;
		}
	}
	
	public void turnLeft(){
		dy = 0;
		dx = 2;
		turnL = true;
	}
	
	public void turnRight(){
		dy = 0;
		dx = -2;
		turnR = true;
	}

	public void forward(){
		dy = 1;
		dx = 0;
		if(rand.nextInt(500) <= 5){
			shouldStop = true;
		}
	}
}
