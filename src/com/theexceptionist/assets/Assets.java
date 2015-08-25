package com.theexceptionist.assets;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage wood1, wood2, wood3;
	public static BufferedImage coderx1, coderx2, coderx3;
	public static BufferedImage typeA1, typeAA1, typeA2, typeAA2, typeA3, typeAA3;
	public static BufferedImage typeB1,typeBB1, typeB2, typeBB2, typeB3, typeBB3;
	public static BufferedImage typeC1, typeCC1, typeC2, typeCC2, typeC3, typeCC3;
	public static BufferedImage rug1, rug2;
	public static BufferedImage melite1, melite2;
	public static BufferedImage splat;
	public static BufferedImage player1, player2, player3, player4;
	public static BufferedImage mark1, mark2, emark1, emark2, emark3;
	public static BufferedImage waffle1, waffleP;
	public static BufferedImage table1, table2;
	public static BufferedImage heart1;
	public static BufferedImage stunW;
	
	public static void load(){
		SpriteLoader loader = new SpriteLoader();
		Sprite w = new Sprite(loader.load("/Art/Sprites/wooden_planks_1.png"));
		Sprite w1 = new Sprite(loader.load("/Art/Sprites/wooden_planks_2.png"));
		Sprite w2 = new Sprite(loader.load("/Art/Sprites/wooden_planks_3.png"));
		
		Sprite a = new Sprite(loader.load("/Art/Sprites/type_a_style_1_sprite.png"));
		Sprite a1 = new Sprite(loader.load("/Art/Sprites/type_a_style_2_sprite.png"));
		Sprite a2 = new Sprite(loader.load("/Art/Sprites/type_a_style_3_sprite.png"));
		
		Sprite b = new Sprite(loader.load("/Art/Sprites/type_b_style_1_sprite.png"));
		Sprite b1 = new Sprite(loader.load("/Art/Sprites/type_b_style_2_sprite.png"));
		Sprite b2 = new Sprite(loader.load("/Art/Sprites/type_b_style_3_sprite.png"));
		
		Sprite c = new Sprite(loader.load("/Art/Sprites/type_c_style_1_sprite.png"));
		Sprite c1 = new Sprite(loader.load("/Art/Sprites/type_c_style_2_sprite.png"));
		Sprite c2 = new Sprite(loader.load("/Art/Sprites/type_c_style_3_sprite.png"));
		
		Sprite r1 = new Sprite(loader.load("/Art/Sprites/rug1.png"));
		Sprite r2 = new Sprite(loader.load("/Art/Sprites/rug2.png"));
		
		Sprite t1 = new Sprite(loader.load("/Art/Sprites/table1.png"));
		Sprite t2 = new Sprite(loader.load("/Art/Sprites/table2.png"));
		
		Sprite m1 = new Sprite(loader.load("/Art/Sprites/mark_sprite.png"));
		
		Sprite p1 = new Sprite(loader.load("/Art/Sprites/player_1_sprite.png"));
		
		Sprite wa1 = new Sprite(loader.load("/Art/Sprites/waffle_regular.png"));
		
		Sprite wp1 = new Sprite(loader.load("/Art/Sprites/pancake_particle.png"));
		
		Sprite h1 = new Sprite(loader.load("/Art/Sprites/heart.png"));
		
		Sprite s1 = new Sprite(loader.load("/Art/Sprites/splat.png"));
		
		Sprite cx = new Sprite(loader.load("/Art/Sprites/coder_x.png"));
		
		Sprite me = new Sprite(loader.load("/Art/Sprites/master_elite.png"));
		
		Sprite em = new Sprite(loader.load("/Art/Sprites/evil_mark.png"));
		
		Sprite sw = new Sprite(loader.load("/Art/Sprites/waffle_cherry.png"));
		
		stunW = sw.crop(0, 0, 16, 16, 16, 16);
		
		waffleP = wp1.crop(0, 0, 16, 16, 16, 16);
		
		wood1 = w.crop(0, 0, 36, 32, 36, 32);
		wood2 = w1.crop(0, 0, 36, 30, 36, 30);
		wood3 = w2.crop(0, 0, 36, 30, 36, 30);
		
		typeC1 = c.crop(0, 0, 16, 16, 16, 16);
		typeCC1 = c.crop(1, 0, 16, 16, 16, 16);
		
		melite1 = me.crop(0, 0, 16, 16, 16, 16);
		melite2 = me.crop(1, 0, 16, 16, 16, 16);
		
		coderx1 = cx.crop(0, 0, 16, 16, 16, 16);
		coderx2 = cx.crop(1, 0, 16, 16, 16, 16);
		coderx3 = cx.crop(0, 0, 16, 16, 16, 16);
		
		typeC2 = c1.crop(0, 0, 16, 16, 16, 16);
		typeCC2 = c1.crop(1, 0, 16, 16, 16, 16);
		
		typeC3 = c2.crop(0, 0, 16, 16, 16, 16);
		typeCC3 = c2.crop(1, 0, 16, 16, 16, 16);
		
		typeB1 = b.crop(0, 0, 16, 16, 16, 16);
		typeBB1 = b.crop(1, 0, 16, 16, 16, 16);
		
		typeB2 = b1.crop(0, 0, 16, 16, 16, 16);
		typeBB2 = b1.crop(1, 0, 16, 16, 16, 16);
		
		typeB3 = b2.crop(0, 0, 16, 16, 16, 16);
		typeBB3 = b2.crop(1, 0, 16, 16, 16, 16);
		
		typeA1 = a.crop(0, 0, 16, 16, 16, 16);
		typeAA1 = a.crop(1, 0, 16, 16, 16, 16);
		
		typeA2 = a1.crop(0, 0, 16, 16, 16, 16);
		typeAA2 = a1.crop(1, 0, 16, 16, 16, 16);
		
		typeA3 = a2.crop(0, 0, 16, 16, 16, 16);
		typeAA3 = a2.crop(1, 0, 16, 16, 16, 16);
		
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
		
		mark1 = m1.crop(0, 0, 12, 11, 11, 24);
		mark2 = m1.crop(1, 0, 12, 11, 11, 24);
		
		emark1 = em.crop(0, 0, 12, 11, 11, 24);
		emark2 = em.crop(1, 0, 12, 11, 11, 24);
		emark3 = em.crop(2, 0, 12, 11, 11, 24);
	}
}
