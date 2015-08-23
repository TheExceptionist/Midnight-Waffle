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
	
