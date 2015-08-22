package com.theexceptionist.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.theexceptionist.gamestate.GameStateManager;

public class GameMain extends JPanel implements Runnable, KeyListener{
	public static final int width = 400;
	public static final int height = 500;
	public static final int scale = 2;
	
	private boolean running = false;
	private Thread thread;
	private int fps = 60;
	private int targetTime = 1000 / fps;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private GameStateManager gsm;
		
	private void init(){
		gsm = new GameStateManager();
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
	}
	
	public GameMain(){
		super();
		setPreferredSize(new Dimension(width*scale, height * scale));
		setFocusable(true);
		requestFocus();
	}

	public void addNotify(){
		super.addNotify();
		if(thread == null){
			thread = new Thread();
			addKeyListener(this);
			thread.start();
		}
	}

	public void keyPressed(KeyEvent arg0) {
		
		
	}


	public void keyReleased(KeyEvent arg0) {
		
		
	}


	public void keyTyped(KeyEvent arg0) {
		
		
	}


	public void run() {
		init();
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			if(wait < 0) wait = 5;
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	private void update() {
		gsm.update();
	}

	private void draw() {
		gsm.draw(g);	
	}

	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, width * scale, height * scale, null);
		g2.dispose();
	}

}
