# Midnight-Waffle
width: 400,height: 500,scale: 2

To change:
    					Audio.class.getResource(s)

    	protected int targetX, targetY; 

		wanderThief();
		
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

Horde mode code:

			if(r.nextInt(500 * (GameMain.numMarks / GameMain.wave)) <= 10 * GameMain.waveCount){
				HordeMode();
			}
			
				private void HordeMode(){
		h.addText(new SplashText("Horde Incoming!!!!", 200, -10, h));
		int numPeople = r.nextInt(10 * (GameMain.numMarks / GameMain.wave)) + 10;
		
		for(int i = 0; i < numPeople; i++){
			if(r.nextInt(100 * GameMain.wave) <= 5 * GameMain.wave){
				h.addObject(new EnemyThief("Nerd Thief", r.nextInt(250), -10, 16, 16, h));
			}else if(r.nextInt(200 * GameMain.wave) <= 10 * GameMain.wave){
				h.addObject(new EnemyThrower("Nerd Thrower", r.nextInt(250), -10, 16, 16, h));
			}else{
				h.addObject(new EnemyRunner("Nerd Runner", r.nextInt(250), -10, 16, 16, h));
			}
		}
	}
	
