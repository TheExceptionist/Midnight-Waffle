package com.theexceptionist.assets;

import java.awt.image.BufferedImage;

public class Sprite {
	private BufferedImage sheet;
	
	public Sprite(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int col, int row, int rowSize, int colSize, int w, int h){
		//returns cropped out image of the sheet
		System.out.println(sheet.getHeight()+" "+sheet.getWidth());
		return sheet.getSubimage(col * colSize, row * rowSize, w, h);
	}
	
	public BufferedImage getImage(){
		return sheet;
	}
}
