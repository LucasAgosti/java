package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	public double x,y;
	public int wid, hei;
	public double dx, dy;
	public double speed = 1.5;
	
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.wid = 4;
		this.hei = 4;
		
		int angle = new Random().nextInt(120 - 45) + 45;
		this.dx = Math.cos(Math.toRadians(angle));
		this.dy = Math.sin(Math.toRadians(angle));
		//this.dx = new Random().nextGaussian();
		//this.dy = new Random().nextGaussian();
	}
	
	public void tick() {
		
		x += dx * speed;
		y += dy * speed;
		
		//LIMITES DA BOLA NO EIXO X
		if(x + (dx * speed) + wid >= Game.WIDTH) {
			dx *= -1;
			
		}else if(x + (dx * speed) < 0) {
			dx *= -1;
		}
		
		//PONTUAÇÕES
		if(y >= Game.HEIGHT) {
			//INIMIGO PONTUA
			new Game();
			return;
			
		}else if(y < 0) {
			//PONTO DO PLAYER
			new Game();
			return;
		}
		
		//FAZENDO COLISÕES COM OS JOGADORES
		
		Rectangle bounds = new Rectangle((int)(x + (dx * speed)), (int)(y + (dy * speed)), wid, hei);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.wid, Game.player.hei);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.wid, Game.enemy.hei);
	
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120 - 45) + 45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy > 0) 
				dy *= -1;
			
			
		}else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120 - 45) + 45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy < 0) 
				dy *= -1;
			
		}
		
	}
	
	public void render(Graphics gph) {
		gph.setColor(Color.GREEN);
		gph.fillOval((int)x, (int)y, wid, hei);
		
	}
}
