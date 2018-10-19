package com.poogametopview.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Entity {
	
	//ATRIBUTOS
	protected double x;
	protected double y;
	protected int wid;
	protected int hei;
	
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
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	
	public int getX() {
		return (int)this.x;
	}
	public int getY() {
		return (int)this.y;
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
