package com.theexceptionist.main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public static void main(String[] args){
		GameMain game = new GameMain();
		game.setMinimumSize(new Dimension(game.width * game.scale, game.height * game.scale));
		game.setMaximumSize(new Dimension(game.width * game.scale, game.height * game.scale));
		game.setPreferredSize(new Dimension(game.width * game.scale, game.height * game.scale));
		
		JFrame window = new JFrame(game.name);
		window.add(game);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
}
