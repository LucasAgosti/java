package com.poogametopview.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.javagame.main.Game;

public class Player extends Entity{

	public boolean right, left, up, down;
	public double speed = 0.8;
	public int rightDir = 0, leftDir = 1;
	public int direction = rightDir;
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 3;
	private boolean moved = false;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	
	
	public Player(int x, int y, int wid, int hei, BufferedImage sprite) {
		super(x, y, wid, hei, sprite);
		
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			rightPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 0, 16, 16);
		}
		for(int i = 0; i < 4; i++) {
			leftPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 16, 16, 16);
		}
	}
	
	public void tick() {
		moved = false;
		if(right) {
			moved = true;
			direction = rightDir;
			x += speed;
		}else if(left) {
			moved = true;
			direction = leftDir;
			x -= speed;
		}
		
		if(up) {
			moved = true;
			y -= speed;
		}else if(down) {
			moved = true;
			y += speed;
		}
		
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		}
	}
	
	public void render(Graphics gph) {
		if(direction == rightDir) {
			gph.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
		}else if(direction == leftDir) {
			gph.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
		}else {
			
		}
	}
}
