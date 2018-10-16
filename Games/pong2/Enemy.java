package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

	//ATRIBUTOS
	public double x, y;
	public int wid, hei;
	
	//METODO CONSTRUTOR
	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		this.wid = 40;
		this.hei = 5;
	}
	
	public void tick() {
		
		x += (Game.ball.x - x) * 0.2;
	}
	
	public void render(Graphics gph) {
	
		gph.setColor(Color.blue);
		gph.fillRect((int)x, (int)y, wid, hei);
	}
}
