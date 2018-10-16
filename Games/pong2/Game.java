package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	//ATRIBUTOS
	public final static int WIDTH = 160;
	public final static int HEIGHT = 120;
	public final static int SCALE = 3;

	public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	
	//METODO CONSTRUTOR GAME
	public Game(int count_player, int count_enemy) {
		
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.addKeyListener(this);
		
		player = new Player((WIDTH/2) - 20, HEIGHT - 5, count_player);
		enemy = new Enemy((WIDTH/2) - 20, 0, count_enemy);
		ball = new Ball((WIDTH/2), HEIGHT /2 - 1);
	}
	
	public static void main(String[] args) {
		
		int count_enemy = 0;
		int count_player = 0;
		Game pong = new Game(count_player, count_enemy);
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pong);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(pong).start();
	}
	
	public void tick() {
		player.tick();
		enemy.tick();
		ball.tick();
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics gph = layer.getGraphics();
		gph.setColor(Color.black);
		gph.fillRect(0, 0, WIDTH, HEIGHT);
		player.render(gph);
		enemy.render(gph);
		ball.render(gph);
		
		gph = bs.getDrawGraphics();
		gph.drawImage(layer, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		
		bs.show();	
	}
	
	public void run() {
		
		//GAME LOOP
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}

	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
