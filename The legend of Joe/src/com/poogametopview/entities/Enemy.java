package com.poogametopview.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.poogametopview.main.Game;
import com.poogametopview.map.Camera;
import com.poogametopview.map.World;

public class Enemy extends Entity{

	private double speed = 0.6;
	private int maskX = 8, maskY = 8;
	private int maskWid = 10, maskHei = 10;
	
	private int frames = 0, maxFrames = 10, index = 0, maxIndex = 1;
	private int damageFrames = 8, damageCurrent = 0;
	//Maxframes = velocidade da animação
	private int direcao = 1;
	private int enemyHP = 4;
	
	private BufferedImage[] rightEnemy;
	private BufferedImage[] leftEnemy;
	private boolean enDamaged = false;

	/*AS MASCARAS SERVEM PARA FAZER OS INIMIGOS COLIDIREM NA MASCARA SETADA E NÃO NO
	TAMANHO DA ARTE DO INIMIGO (no caso 16 x 16)*/		
	
	public Enemy(int x, int y, int wid, int hei, BufferedImage sprite) {
		super(x, y, wid, hei, null);
		rightEnemy = new BufferedImage[2];
		leftEnemy = new BufferedImage[2];
		
		rightEnemy[0] = Game.spritesheet.getSprite(112, 16, 16, 16);
		rightEnemy[1] = Game.spritesheet.getSprite(128, 16, 16, 16);
		
		leftEnemy[0] = Game.spritesheet.getSprite(112, 32, 16, 16);
		leftEnemy[1] = Game.spritesheet.getSprite(128, 32, 16, 16);
		
	}

	public void tick() {
		
		if(this.playerCollision() == false) {
		
			if((int)x < Game.player.getX() && World.isFree((int)(x + speed), this.getY())
				&& !(isColliding((int)(x + speed), this.getY()))) {
				x += speed;
				direcao = 1;
				
			}else if((int)x > Game.player.getX() && World.isFree((int)(x - speed), this.getY())
					&& !(isColliding((int)(x - speed), this.getY()))) {
				x -= speed;
				direcao = -1;
				
			} 
			
			if((int)y < Game.player.getY() && World.isFree(this.getX(), (int)(y + speed))
					&& !(isColliding(this.getX(), (int)(y + speed)))) {
				y += speed;
				
			}else if((int)y > Game.player.getY() && World.isFree(this.getX(), (int)(y - speed))
					&& !(isColliding(this.getX(), (int)(y - speed)))){
				y -= speed;
			}
			}else {
				//ESTÁ COLIDINDO
				if(Game.rand.nextInt(100) < 10) {
					Game.player.life -= Game.rand.nextInt(3);
					Game.player.isDamaged = true;
				}
			}
		
		frames++;
					
		if(frames == maxFrames) {
			frames = 0;
			index++;
			if(index > maxIndex) {
				index = 0;
			}
		}
		
		bulletCollision();
		
		if(enemyHP <= 0) {
			destroyEnemy();
			return;
		}
		
		if(enDamaged) {
			this.damageCurrent++;
			if(this.damageCurrent == this.damageFrames) {
				this.damageCurrent = 0;
				this.enDamaged = false;
			}
		}
	}
	
	public void render(Graphics gphs) {
		
		if(!enDamaged) {
			if(direcao == 1) {
				gphs.drawImage(rightEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			
			}else if(direcao == -1) {
				gphs.drawImage(leftEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				
			}	
		}else if(enDamaged){
			gphs.drawImage(Entity.FEEDBACK_EN, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		//gphs.setColor(Color.blue);
		//gphs.fillRect(this.getX() + maskX - Camera.x, this.getY() + maskY - Camera.y, maskWid, maskHei);
	}
	
	public void destroyEnemy() {
		Game.enemies.remove(this);
		Game.entities.remove(this);
	}
	
	public void bulletCollision() {
		
		for(int i = 0; i < Game.bullets.size(); i++) {
			Entity en = Game.bullets.get(i);

			if(en instanceof Shot) {
				
				if(Entity.isColliding(this, en)) {
					enDamaged = true;
					enemyHP--;
					Game.bullets.remove(i);
					return;
				}
			}
		}
		
		for(int i = 0; i < Game.pistolBullets.size(); i++) {
			Entity en = Game.pistolBullets.get(i);
			
			if(en instanceof ShotPistol) {
				
				if(Entity.isColliding(this, en)) {
					enDamaged = true;
					enemyHP--;
					enemyHP--;
					Game.pistolBullets.remove(i);
					return;
				}	
			}
		}
	}
	
	public boolean playerCollision() {
		
		Rectangle currentEnemy = new Rectangle(this.getX() + maskX, this.getY() + maskY, maskWid, maskHei);
		Rectangle player = new Rectangle(Game.player.getX(), Game.player.getY(), 16, 16);
		
		return currentEnemy.intersects(player);
	}
	
	public boolean isColliding(int xNext, int yNext) {
		
		Rectangle currentEnemy = new Rectangle(xNext + maskX, yNext + maskY, maskWid, maskHei);
		
		for(int i = 0; i < Game.enemies.size(); i++) {
			Enemy e = Game.enemies.get(i);
			
			if(e == this)
				continue;
				
			Rectangle targetEnemy = new Rectangle(e.getX() + maskX, e.getY() + maskY, maskWid, maskHei);
			
			if(currentEnemy.intersects(targetEnemy))
				return true;
		}
		return false;
	}
}