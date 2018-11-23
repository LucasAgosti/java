package com.poogametopview.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.poogametopview.entities.Enemy;
import com.poogametopview.entities.Entity;
import com.poogametopview.entities.Player;
import com.poogametopview.entities.Shot;
import com.poogametopview.graphics.Spritesheet;
import com.poogametopview.graphics.UI;
import com.poogametopview.map.World;

public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = true;
	public static JFrame frame;
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	public static final int SCALE = 3;
	private int curLevel = 1;
	private int maxLevel = 2;
	
	private BufferedImage image;
	
	public static List<Entity> entities;
	public static List<Enemy> enemies;
	public static List<Shot> bullets;
	public static Spritesheet spritesheet;
	public static Player player;
	public static World world;
	public static Random rand;
	public UI ui;
	
	public static String gameState = "MENU";
	private boolean showMessageGameOver = true;
	private int framesGameOver = 0;
	private boolean restartGame = false;
	
	public Menu menu;
	
	public Game() {
		
		rand = new Random();
		
		addKeyListener(this); //USO O THIS PORQUE O MÉTODO JÁ ESTA NA PRÓPRIA CLASSE
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		//INICIANDO OBJETOS
		
		ui = new UI();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		entities = new ArrayList<Entity>();
		enemies = new ArrayList<Enemy>();
		bullets = new ArrayList<Shot>();
		spritesheet = new Spritesheet("/spritesheet.png");
		
		player = new Player(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		entities.add(player);
		world = new World("/level1.png");
		
		menu = new Menu();
	}
	
	public void initFrame() {
		frame = new JFrame("JOGUINHO");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	public synchronized void start() {
		
		thread = new Thread(this);
		running = true;
		thread.start();
		
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		
		Game game = new Game();
		game.start();
	}
	
	public void tick() {
		
		if(gameState == "NORMAL") {
			
			this.restartGame = false;
			for(int i = 0; i < entities.size(); i++) {
				
				Entity e = entities.get(i);
				e.tick();
			}
			
			for(int i = 0; i < bullets.size(); i++) 
				bullets.get(i).tick();
			
			if(enemies.size() == 0) {
				//PASSOU DE FASE
				curLevel++;
				if(curLevel > maxLevel) {
					curLevel = 1;
				}
			}
			
		}else if(gameState == "GAME_OVER") {	
			this.framesGameOver++;
			
			if(this.framesGameOver == 30) {
				this.framesGameOver = 0;
				if(this.showMessageGameOver) 
					this.showMessageGameOver = false;
				else
					this.showMessageGameOver = true;	
			}
			
			if(restartGame) {
				this.restartGame = false;
				Game.gameState = "NORMAL";
				curLevel = 1;
				String newWorld = "level" + curLevel + ".png";
				World.restartGame(newWorld);
			}
		}else if(gameState == "MENU") {
			//SISTEMA DE MENU
			menu.tick();
		}

	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics gr = image.getGraphics();
		gr.setColor(new Color(0, 0, 0));
		gr.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		world.render(gr);
		
		for(int i = 0; i < entities.size(); i++) {
			
			Entity e = entities.get(i);
			e.render(gr);
		}
		
		for(int i = 0; i < bullets.size(); i++) 
			bullets.get(i).render(gr);
		
		ui.render(gr);
		
		gr.dispose();
		gr = bs.getDrawGraphics();
		gr.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		//AMMO UI
		gr.setFont(new Font("arial", Font.BOLD, 20));
		gr.setColor(Color.white);
		gr.drawString("AMMO: " + player.ammo, 600, 25);
		
		if(gameState == "GAME_OVER") {
			
			Graphics2D gr2 = (Graphics2D) gr;
			gr2.setColor(new Color(0, 0, 0, 150));
			gr2.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
			
			gr.setFont(new Font("arial", Font.BOLD, 50));
			gr.setColor(Color.red);
			gr.drawString("GAME OVER", (WIDTH * SCALE) / 4 + 35, (HEIGHT * SCALE) / 2);
			
			gr.setFont(new Font("arial", Font.BOLD, 30));
			gr.setColor(Color.red);
			
			if(showMessageGameOver)
				gr.drawString(">PRESS R TO RESTART<", (WIDTH * SCALE) / 4, (HEIGHT * SCALE) / 2 + 100);
		
		}else if(gameState == "MENU") {
			menu.render(gr);
			
		}
		
		bs.show();

	}
	
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
				
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if(System.currentTimeMillis() - timer >= 1000) {
				
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}
		}
		stop();
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			//MOVE PARA A DIREITA
			player.right = true;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			//MOVE PARA A ESQUERDA
			player.left = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			//MOVE PARA CIMA
			player.up = true;
			
			if(gameState == "MENU") {
				menu.up = true;
			}
			
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			//MOVE PARA BAIXO
			player.down = true;
			
			if(gameState == "MENU") {
				menu.down = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_K) {
			
			player.shooting = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_R) {
			
			this.restartGame = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(gameState == "MENU") 
				menu.enter = true;
				
		}
		
		if(e.getKeyCode() == KeyEvent.VK_P) {
			gameState = "MENU";
			menu.pause = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			//PARA O MOVIMENTO PARA DIREITA
			player.right = false;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			//PARA O MOVIMENTO PARA ESQUERDA
			player.left = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			//PARA O MOVIMENTO PARA CIMA
			player.up = false;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			//PARA O MOVIMENTO PARA BAIXO
			player.down = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
}
