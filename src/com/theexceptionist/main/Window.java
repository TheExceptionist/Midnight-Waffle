package com.theexceptionist.main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public static void main(String[] args){
		GameMain game = new GameMain();
		game.setMinimumSize(new Dimension(game.width, game.height));
		game.setMaximumSize(new Dimension(game.width, game.height));
		game.setPreferredSize(new Dimension(game.width, game.height));
		
		JFrame window = new JFrame(game.name);
		window.add(game);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
}
