package com.poogametopview.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.poogametopview.main.Game;
import com.poogametopview.map.Camera;

public class Shot extends Entity{

	private int dirX, dirY;	
	private double speed = 4;
	private int bulletLife = 40, curLife = 0;
	
	public Shot(int x, int y, int wid, int hei, BufferedImage sprite, int dirX, int dirY) {
		super(x, y, wid, hei, sprite);
		this.dirX = dirX;
		this.dirY = dirY;
	}

	public void tick() {
		
		x += dirX * speed;
		y += dirY * speed;
		
		curLife++;
		if(curLife == bulletLife) {
			Game.bullets.remove(this);
			return;
		}
	}
	
	public void render(Graphics gphs) {
		
		gphs.setColor(Color.yellow);
		gphs.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, wid, hei);
	}
	
}