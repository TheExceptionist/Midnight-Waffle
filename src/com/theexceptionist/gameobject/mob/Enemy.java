package com.theexceptionist.gameobject.mob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.theexceptionist.assets.Audio;
import com.theexceptionist.gameobject.GameObject;
import com.theexceptionist.gameobject.Mob;
import com.theexceptionist.gameobject.StunWaffle;
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
	protected int attack;
	private int thrown = 0, throwLim;
	protected int money;
	protected int scoreAmount;
	private boolean PlayerKill = false;
	private boolean shouldStop = false;
	private int waitTime = 0;
	
	private boolean turnL = false, turnR = false;
	protected int sec = 0;
	protected int n = 0;
	protected int targetX, targetY; 
	
	public Enemy(String name, int x, int y, int w, int h, Handler han) {
		super(name, x, y, w, h, han);
		rand = new Random(System.nanoTime());
		type = rand.nextInt(3);
		health = 1 * type;
		turnLim = 10;
		attack = 1 * type;
		throwLim = rand.nextInt(3)+3;
		scoreAmount = rand.nextInt(100)+50 * type;
		
		if(rand.nextInt(100) <= 5){
			int r = rand.nextInt(4);
			isElite = true;
			
			if(r == 0){
				Audio.play("hackerb1");
			}else
			if(r == 1){
				Audio.play("hacker1");
			}else
			if(r == 2){
				Audio.play("hacker3");
			}else
			if(r == 3){
				Audio.play("elite");
			}
			han.addText(new SplashText("Hack Elite Spawned!!!", x, y, han));
		}
		if(isElite){
			health *= 2;
			attack *= 2;
			throwLim *= 2;
			scoreAmount *= 2;
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
		
		if(y > 675){
			die();
		}
		if(x < -20){
			die();
		}
		if(x > 675){
			die();
		}
	}
	
    protected void wanderThief(){
		for(int i = 0; i < han.objects.size(); i++){
		    GameObject tempObject = han.objects.get(i);
		
		    if(tempObject instanceof Player){
		        Player p = (Player) tempObject;
		
		        targetX = p.getX();
		        targetY = p.getY();
		    }
		}
		
		if(isCollidingU){
		            int cho = rand.nextInt(2); 
		    dy = 0;
		    if(cho == 0){
		        turnLeft();
		    }else{
		        turnRight();
		    }
		}else if(x > targetX && x < targetX + 10){
		    forward();
		}else if(x < targetX){
		    turnLeft();
		}else if(x > targetX){
		    turnRight();
		}else{
		    forward();
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
	
	protected void wanderE(){
		if(!shouldStop){
			if(turnL){
				turning++;
				turnLeftE();
				if(turning >= turnLim){
					turning = 0;
					turnL = false;
				}
			}else if(turnR){
				turning++;
				turnRightE();
				if(turning >= turnLim){
					turning = 0;
					turnR = false;
				}
			}else{
				if(isCollidingU){
					dy = 0;
					if(rand.nextInt(2) == 0){
						turnLeftE();
					}else{
						turnRightE();
					}
				}else if(rand.nextInt(500) <= 1){
					if(rand.nextInt(2) == 0){
						turnLeftE();
					}else{
						turnRightE();
					}
				}else{
					forwardE();
				}
			}
		}
}
	
	protected void wanderThrower(boolean isElite){
		if(!shouldStop){
			if(turnL){
				turning++;
				turnLeftE();
				if(turning >= turnLim){
					turning = 0;
					turnL = false;
				}
			}else if(turnR){
				turning++;
				turnRightE();
				if(turning >= turnLim){
					turning = 0;
					turnR = false;
				}
			}else{
				if(isCollidingU){
					dy = 0;
					if(rand.nextInt(2) == 0){
						turnLeftE();
					}else{
						turnRightE();
					}
				}else if(rand.nextInt(500) <= 1){
					if(rand.nextInt(2) == 0){
						turnLeftE();
					}else{
						turnRightE();
					}
				}else{
					forwardE();
				}
			}
		}else{
			waitTime++;
			if(waitTime >= 100){
				shouldStop = false;
			}
		}
	}
	
	protected void aim(int type, boolean isElite){
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
		
		if(!isElite){
			if(type == 0){
				han.addObject(new Waffles("Waffle", x + 4, y, 8, 8, han, 2));
				numPancakes--;
			}else{
				han.addObject(new StunWaffle("Stun Waffle", x + 4, y + 18, 8, 8, han, 2));
			}
		}else{
			if(type == 0){
				han.addObject(new Waffles("Waffle", x + 4, y + 32, 8, 8, han, 2));
				numPancakes--;
			}else{
				han.addObject(new StunWaffle("Stun Waffle", x + 4, y + 40, 8, 8, han, 2));
			}
		}
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
				
			    if(m.getBounds().intersects(getBounds()) && coolDown == 0){
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
						p.setMoney(rand.nextInt(25*type)+money);
						han.addText(new SplashText("Money Gained!!!!", x, y, han));
					}
					
					p.setScore(scoreAmount);
					GameMain.waveCount++;
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
	
	public void turnLeftE(){
		dy = 0;
		dx = 1;
		turnL = true;
	}
	
	public void turnRightE(){
		dy = 0;
		dx = -1;
		turnR = true;
	}

	public void forwardE(){
		dy = 1;
		dx = 0;
		if(rand.nextInt(500) <= 5){
			shouldStop = true;
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

	public int getHealth() {
		return health;
	}
}
