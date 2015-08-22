package com.theexceptionist.assets;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage wood1, wood2, wood3;
	
	public static void load(){
		SpriteLoader loader = new SpriteLoader();
		Sprite w = new Sprite(loader.load("/Art/Sprites/wooden_planks_1.png"));
		Sprite w1 = new Sprite(loader.load("/Art/Sprites/wooden_planks_1.png"));
		Sprite w2 = new Sprite(loader.load("/Art/Sprites/wooden_planks_1.png"));
		
		wood1 = w.crop(0, 0, 36, 32, 36, 32);
		wood2 = w1.crop(0, 0, 36, 32, 36, 32);
		wood3 = w2.crop(0, 0, 36, 32, 36, 32);
	}
}
