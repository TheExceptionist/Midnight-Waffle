package com.theexceptionist.assets;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage wood1, wood2, wood3;
	public static BufferedImage rug1, rug2;
	public static BufferedImage splat;
	public static BufferedImage table1, table2;
	
	public static void load(){
		SpriteLoader loader = new SpriteLoader();
		Sprite w = new Sprite(loader.load("/Art/Sprites/wooden_planks_1.png"));
		Sprite w1 = new Sprite(loader.load("/Art/Sprites/wooden_planks_2.png"));
		Sprite w2 = new Sprite(loader.load("/Art/Sprites/wooden_planks_3.png"));
		
		Sprite r1 = new Sprite(loader.load("/Art/Sprites/rug1.png"));
		Sprite r2 = new Sprite(loader.load("/Art/Sprites/rug2.png"));
		
		Sprite t1 = new Sprite(loader.load("/Art/Sprites/table1.png"));
		Sprite t2 = new Sprite(loader.load("/Art/Sprites/table2.png"));
		
		wood1 = w.crop(0, 0, 36, 32, 36, 32);
		wood2 = w1.crop(0, 0, 36, 30, 36, 30);
		wood3 = w2.crop(0, 0, 36, 30, 36, 30);
		
		rug1 = r1.crop(0, 0, 32, 32, 32, 32);
		rug2 = r2.crop(0, 0, 32, 32, 32, 32);
		
		table1 = t1.crop(0, 0, 32, 32, 32, 32);
		table2 = t2.crop(0, 0, 32, 32, 32, 32);
		
	}
}
