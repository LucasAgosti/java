package com.poogametopview.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.poogametopview.main.Game;
import com.poogametopview.map.Camera;

public class Entity {
	
	public static BufferedImage LIFEPACK_EN = Game.spritesheet.getSprite(6 * 16, 0, 16, 16);
	public static BufferedImage GUN_EN = Game.spritesheet.getSprite(7 * 16, 0, 16, 16);
	public static BufferedImage PISTOL_EN = Game.spritesheet.getSprite(16 * 2, 16 * 5, 16, 16);
	public static BufferedImage WEAPONAMMO_EN = Game.spritesheet.getSprite(6 * 16, 16, 16, 16);
	public static BufferedImage ENEMY_EN = Game.spritesheet.getSprite(7 * 16, 16, 16, 16);
	public static BufferedImage WEAPON_RIGHT = Game.spritesheet.getSprite(128, 0, 16, 16);
	public static BufferedImage WEAPON_LEFT = Game.spritesheet.getSprite(144, 0, 16, 16);
	public static BufferedImage PISTOL_RIGHT = Game.spritesheet.getSprite(16 * 0, 16 * 5, 16, 16);
	public static BufferedImage PISTOL_LEFT = Game.spritesheet.getSprite(16 * 1, 16 * 5, 16, 16);
	
	public static BufferedImage FEEDBACK_EN = Game.spritesheet.getSprite(9 * 16, 16, 16, 16);
	public static BufferedImage FEEDBACK2_EN = Game.spritesheet.getSprite(9 * 16, 16 * 3, 16, 16);
	
	public static BufferedImage ENEMY2_EN = Game.spritesheet.getSprite(7 * 16, 3 * 16, 16, 16);
	public static BufferedImage BOSS_EN = Game.spritesheet.getSprite(0 * 16, 3 * 16, 16, 16);
	public static BufferedImage FEEDBACKBOSS_EN = Game.spritesheet.getSprite(3 * 16, 16 * 4, 16, 16);

	
	//ATRIBUTOS	
	protected double x;
	protected double y;
	protected int wid;
	protected int hei;
	
	private BufferedImage sprite;
	private int maskX, maskY, maskWid, maskHei;
	public boolean debug = false;
	
	//MÉTODO CONSTRUTOR
	public Entity(int x, int y, int wid, int hei, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.wid = wid;
		this.hei = hei;	
		this.sprite = sprite;
		
		this.maskX = 0;
		this.maskY = 0;
		this.maskWid = wid;
		this.maskHei = hei;
	}
	
	public void setMask(int maskX, int maskY, int maskWid, int maskHei) {
		
		this.maskX = maskX;
		this.maskY = maskY;
		this.maskWid = maskWid;
		this.maskHei = maskHei;
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
		
		gphs.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);

		//gphs.setColor(Color.red);
		//gphs.fillRect(this.getX() + maskX - Camera.x, this.getY() + maskY - Camera.y, maskWid, maskHei);
	}
	
	public static boolean isColliding(Entity e1, Entity e2) {
		
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskX, e1.getY() + e1.maskY, e1.maskWid, e1.maskHei);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskX, e2.getY() + e2.maskY, e2.maskWid, e2.maskHei);
		
		return e1Mask.intersects(e2Mask);
	}
}