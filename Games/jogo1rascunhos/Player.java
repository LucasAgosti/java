package com.poogametopview.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.poogametopview.graphics.Spritesheet;
import com.poogametopview.main.Game;
import com.poogametopview.map.Camera;
import com.poogametopview.map.World;

public class Player extends Entity{

	public boolean right, left, up, down;
	public double speed = 1.2;
	public int rightDir = 0, leftDir = 1;
	public int direction = rightDir;
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 3;
	private boolean moved = false;
	
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage playerDamage;
	
	public double life = 100, maxLife = 100;
	public static int maxAmmo = 20;
	public int ammo = 0;
	public boolean isDamaged = false;
	private int damageFrames = 0;
	
	private boolean holdingGun = false;
	public boolean shooting = false;
	
	public Player(int x, int y, int wid, int hei, BufferedImage sprite) {
		super(x, y, wid, hei, sprite);
		
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		playerDamage = Game.spritesheet.getSprite(0, 16, 16, 16);
		
		for(int i = 0; i < 4; i++) {
			rightPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 0, 16, 16);
		}
		for(int i = 0; i < 4; i++) {
			leftPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 16, 16, 16);
		}
	}
	
	public void tick() {
		
		moved = false;
		
		if(right && World.isFree((int)(x + speed), this.getY())) {
			moved = true;
			direction = rightDir;
			x += speed;
		}else if(left && World.isFree((int)(x - speed), this.getY())) {
			moved = true;
			direction = leftDir;
			x -= speed;
		}
		
		if(up && World.isFree(this.getX() , (int)(y - speed))) {
			moved = true;
			y -= speed;
		}else if(down && World.isFree(this.getX(), (int)(y + speed))) {
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
		
		checkWeaponCollision();
		checkLifeCollision();
		checkAmmoCollision();
		
		if(isDamaged) {
			this.damageFrames++;
			if(this.damageFrames == 8)
				this.damageFrames = 0;
				isDamaged = false;
				
		}
		
		if(shooting) {
			//CRIAR BALA E ATIRAR
			shooting = false;
			if(holdingGun && ammo > 0) {
				ammo--;
				int dirX = 0;
				int originX = 0, originY = 6;
				
				if(direction == rightDir) {
					dirX = 1;
					originX = 16;
				}else{
					dirX = -1;
					originX = -4;
				}
				
				Shot bullet = new Shot(this.getX() + originX, this.getY() + originY, 3, 3, null, dirX, 0);
				Game.bullets.add(bullet);
			}
		}
		
		if(life <=  0) {
			//GAME OVER
			life = 0;
			Game.gameState = "GAME_OVER";

		}
		
		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH/2), 0, World.WIDTH * 16 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT/2), 0, World.HEIGHT * 16- Game.HEIGHT);
	}
	
	public void checkWeaponCollision() {
		
		for(int i = 0; i < Game.entities.size(); i++) {
			
			Entity atual = Game.entities.get(i);	
			if(atual instanceof Weapon) {
				if(Entity.isColliding(this, atual)) {
					holdingGun = true;
					ammo += 10;
					Game.entities.remove(atual);
					return;
				}
			}
		}
		
	}
	
	public void checkAmmoCollision() {
		
		for(int i = 0; i < Game.entities.size(); i++) {
			
			Entity atual = Game.entities.get(i);	
			if(atual instanceof Ammo) {
				if(Entity.isColliding(this, atual)) {
					ammo += 30;
					/*if(ammo >= 20)
						ammo = 20;*/
					
					Game.entities.remove(atual);
					return;
				}
			}
		}
		
	}
	
	public void checkLifeCollision() {
		
		for(int i = 0; i < Game.entities.size(); i++) {
			
			Entity atual = Game.entities.get(i);	
			if(atual instanceof Item) {
				if(Entity.isColliding(this, atual)) {
					life += 10;
					if(life >= 100)
						life = 100;
					
					Game.entities.remove(atual);
					return;
				}
			}
		}
	}
	
	public void render(Graphics gph) {
		
		if(!isDamaged) {
			if(direction == rightDir) {
				gph.drawImage(rightPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				
				if(holdingGun == true)
					gph.drawImage(Entity.WEAPON_RIGHT, this.getX() - Camera.x + 6, this.getY() - Camera.y, null);
				
			}else if(direction == leftDir) {
				gph.drawImage(leftPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				
				if(holdingGun == true)
					gph.drawImage(Entity.WEAPON_LEFT, this.getX() - Camera.x - 6, this.getY() - Camera.y, null);
				
			}else {
				
			}
		}else {
			gph.drawImage(playerDamage, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		
	}
}
