package com.poogametopview.entities;

import java.awt.image.BufferedImage;

import com.poogametopview.main.Game;



public class SpawnEnemy1 extends Entity{

	private int timer = 60;
	private int curTimer = 0;
	
	
	
	public SpawnEnemy1(int x, int y, int wid, int hei, BufferedImage sprite) {
		super(x, y, wid, hei, sprite);
	}
	
	public void tick() {
		
			curTimer++;
			if(curTimer == timer) {
				//CRIA O ENEMY
				curTimer = 0;
				timer = Game.rand.nextInt(60 - 30) + 30;
				//Enemy enemy = new Enemy(x,y,16,16,Game.rand.nextDouble()+Game.rand.nextInt(2),Entity.ENEMY_EN);
				//Game.entities.add(enemy);
			}
		
		
	}
	
}
