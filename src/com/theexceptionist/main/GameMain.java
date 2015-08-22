package com.theexceptionist.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.theexceptionist.assets.Assets;
import com.theexceptionist.gameobject.Rug;
import com.theexceptionist.gameobject.Table;
import com.theexceptionist.gameobject.WoodTile;
import com.theexceptionist.input.InputHandler;


public class GameMain extends Canvas implements Runnable{
	public static final int width = 400;
	public static final int height = 500;
	public static final int scale = 2;
	public static final String name = "Midnight Waffles";
	
	public static final int StartID = 0;
	public static final int MenuID = 1;
	public static final int GameID = 2;
	public static final int HelpID = 3;
	
	private int currentChoice = 0;
	
	private boolean gen = true;
	
	private InputHandler input = new InputHandler(this); 
	private Handler h = new Handler();
	private Assets a = new Assets();
	
	private Random r = new Random(System.nanoTime());
	
	private int tickCount = 0;
	
	private boolean running = false;
	private Thread thread;
	private int fps = 60;
	private int targetTime = 1000 / fps;

	private String[] options = {"Start","Help","Quit"};
	
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	private int currentStateID;
	private String[] states = {"Start", "Menu", "Game", "Help"};
	private String currentState;
	
	private void init(){
		currentStateID = StartID;
		currentState = states[StartID];
		
		titleFont = new Font("Times New Roman", Font.PLAIN, 40);
		font = new Font("Arial", Font.PLAIN, 30);
		titleColor = new Color(255, 0, 0);
		
		Assets.load();
	}
	
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	public void stop(){
		running = false;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nsPerTick = 1000000000.0 / 60;
		int frames = 0;
		int ticks = 0;
		long lastTimer1 = System.currentTimeMillis();

		init();

		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			while (unprocessed >= 1) {
				ticks++;
				tick();
				unprocessed -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				lastTimer1 += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}
	}

	public void tick() {
		tickCount++;
		if(currentState == "Start"){
			if(tickCount >= 5){
				if(input.up.down) {
					currentChoice--;
					if(currentChoice <= -1){
						currentChoice = 2;
					}
				}
				if(input.down.down) {
					currentChoice++;
					if(currentChoice >= 3){
						currentChoice = 0;
					}
				}
				if(input.choose.down){
					if(options[currentChoice] == "Start"){
						currentState = states[GameID];
					}
					if(options[currentChoice] == "Help"){
						currentState = states[HelpID];
					}
					if(options[currentChoice] == "Quit"){
						System.exit(0);
					}
				}
				tickCount = 0;
			}
		}
		if(currentState == "Menu"){
			
		}
		if(currentState == "Game"){
			if(gen){
				genLevel();
				gen = false;
			}
			
			h.tick();
		}
		if(currentState == "Help"){
			
		}
	}

	private void genLevel() {
		for(int x = 0; x < width * scale; x += 30){
			for(int y = 0; y < height * scale; y += 30){
				h.addTile(new WoodTile(x, y, h));
				
				if(r.nextInt(100) <= 24){
					if(r.nextInt(100) <= 49){
						h.addObject(new Rug("Rug", x, y, 32, 32, h));
					}else{
						h.addObject(new Table("Table", x, y, 32, 32, h));
					}
				}
			}
		}
		
	}

	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width*scale, height*scale);
		
		if(currentState == "Start"){
			g.setColor(titleColor);
			g.setFont(titleFont);
			g.drawString(name, width - 120, height - height / 2);
			
			g.setFont(font);
			for(int i = 0; i < options.length; i++){
				if(i == currentChoice){
					g.setColor(Color.RED);
				}else{
					g.setColor(Color.gray);
				}
				g.drawString(options[i], width, height + 30 * i);
			}
		}
		if(currentState == "Menu"){
			
		}
		if(currentState == "Game"){
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.scale(3, 3);
			h.render(g);
		}
		if(currentState == "Help"){
			
		}
		
		g.dispose();
		bs.show();
	}
}
