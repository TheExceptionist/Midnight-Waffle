package com.theexceptionist.assets;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage wood1, wood2, wood3;
	public static BufferedImage rug1, rug2;
	public static BufferedImage splat;
	public static BufferedImage player1, player2, player3, player4;
	public static BufferedImage mark1, mark2;
	public static BufferedImage waffle1;
	public static BufferedImage table1, table2;
	public static BufferedImage heart1;
	
	public static void load(){
		SpriteLoader loader = new SpriteLoader();
		Sprite w = new Sprite(loader.load("/Art/Sprites/wooden_planks_1.png"));
		Sprite w1 = new Sprite(loader.load("/Art/Sprites/wooden_planks_2.png"));
		Sprite w2 = new Sprite(loader.load("/Art/Sprites/wooden_planks_3.png"));
		
		Sprite r1 = new Sprite(loader.load("/Art/Sprites/rug1.png"));
		Sprite r2 = new Sprite(loader.load("/Art/Sprites/rug2.png"));
		
		Sprite t1 = new Sprite(loader.load("/Art/Sprites/table1.png"));
		Sprite t2 = new Sprite(loader.load("/Art/Sprites/table2.png"));
		
		Sprite m1 = new Sprite(loader.load("/Art/Sprites/mark_sprite.png"));
		
		Sprite p1 = new Sprite(loader.load("/Art/Sprites/player_1_sprite.png"));
		
		Sprite wa1 = new Sprite(loader.load("/Art/Sprites/waffle_regular.png"));
		
		Sprite h1 = new Sprite(loader.load("/Art/Sprites/heart.png"));
		
		Sprite s1 = new Sprite(loader.load("/Art/Sprites/splat.png"));
		
		wood1 = w.crop(0, 0, 36, 32, 36, 32);
		wood2 = w1.crop(0, 0, 36, 30, 36, 30);
		wood3 = w2.crop(0, 0, 36, 30, 36, 30);
		
		rug1 = r1.crop(0, 0, 32, 32, 32, 32);
		rug2 = r2.crop(0, 0, 32, 32, 32, 32);
		
		table1 = t1.crop(0, 0, 32, 32, 32, 32);
		table2 = t2.crop(0, 0, 32, 32, 32, 32);
		
		player1 = p1.crop(0, 0, 16, 16, 16, 16);
		player2 = p1.crop(1, 0, 16, 16, 16, 16);
		player3 = p1.crop(2, 0, 16, 16, 16, 16);
		player4 = p1.crop(3, 0, 16, 16, 16, 16);
		
		waffle1 = wa1.crop(0, 0, 32, 32, 32, 32);
		
		heart1 = h1.crop(0, 0, 32, 32, 32, 32);
		
		splat = s1.crop(0, 0, 32, 32, 32, 32);
		
		mark1 = m1.crop(0, 0, 16, 16, 16, 16);
		mark2 = m1.crop(1, 0, 16, 16, 16, 16);
	}
}
