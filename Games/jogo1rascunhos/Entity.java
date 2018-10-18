package com.poogametopview.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Entity {
	
	//ATRIBUTOS
	private int x;
	private int y;
	private int wid;
	private int hei;
	
	private BufferedImage sprite;
	
	//MÉTODO CONSTRUTOR
	public Entity(int x, int y, int wid, int hei, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.wid = wid;
		this.hei = hei;	
		this.sprite = sprite;
	}
	
	//MÉTODOS SET E GET
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth() {
		return this.wid;
	}
	public int getHeight() {
		return this.hei;
	}
	
	public void tick() {
		
		
	}
	
	public void render(Graphics gphs) {
		
		gphs.drawImage(sprite, this.getX(), this.getY(), null);
	}
}
