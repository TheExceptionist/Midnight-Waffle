package com.theexceptionist.main;

import javax.swing.JFrame;

public class Window {
	
	public static void main(String[] args){
		JFrame window = new JFrame("Midnight Waffles");
		window.add(new GameMain());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.pack();
		window.setLocationRelativeTo(null);
	}
}
