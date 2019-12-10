package com.poogametopview.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.poogametopview.main.Game;
import com.poogametopview.map.Camera;
import com.poogametopview.map.World;

public class Boss extends Entity{

	private double speed = 0.3;
	private int maskX = 8, maskY = 8;
	private int maskWid = 10, maskHei = 10;
	
	private int frames = 0, maxFrames = 10, index = 0, maxIndex = 1;
	private int damageFrames = 8, damageCurrent = 0;
	//Maxframes = velocidade da animação
	private int direcao = 1;
	private int enemyHP = 30;
	
	private BufferedImage[] rightBoss;
	private BufferedImage[] leftBoss;
	private boolean enDamaged = false;

	/*AS MASCARAS SERVEM PARA FAZER OS INIMIGOS COLIDIREM NA MASCARA SETADA E NÃO NO
	TAMANHO DA ARTE DO INIMIGO (no caso 16 x 16)*/		
	
	public Boss(int x, int y, int wid, int hei, BufferedImage sprite) {
		super(x, y, wid, hei, null);
		rightBoss = new BufferedImage[3];
		leftBoss = new BufferedImage[3];
		
		rightBoss[0] = Game.spritesheet.getSprite(16 * 0, 16 * 3, 16, 16);
		rightBoss[1] = Game.spritesheet.getSprite(16 * 1, 16 * 3, 16, 16);
		rightBoss[2] = Game.spritesheet.getSprite(16 * 2, 16 * 3, 16, 16);
		
		leftBoss[0] = Game.spritesheet.getSprite(16 * 0, 16 * 4, 16, 16);
		leftBoss[1] = Game.spritesheet.getSprite(16 * 1, 16 * 4, 16, 16);
		leftBoss[2] = Game.spritesheet.getSprite(16 * 2, 16 * 4, 16, 16);
		
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
					Game.player.life -= Game.rand.nextInt(50);
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
				gphs.drawImage(rightBoss[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			
			}else if(direcao == -1) {
				gphs.drawImage(leftBoss[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				
			}	
		}else if(enDamaged){
			gphs.drawImage(Entity.FEEDBACKBOSS_EN, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		//gphs.setColor(Color.blue);
		//gphs.fillRect(this.getX() + maskX - Camera.x, this.getY() + maskY - Camera.y, maskWid, maskHei);
	}
	
	public void destroyEnemy() {
		Game.boss.remove(this);
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
		
		for(int i = 0; i < Game.boss.size(); i++) {
			Boss b = Game.boss.get(i);
			
			if(b == this)
				continue;
				
			Rectangle targetEnemy = new Rectangle(b.getX() + maskX, b.getY() + maskY, maskWid, maskHei);
			
			if(currentEnemy.intersects(targetEnemy))
				return true;
		}
		return false;
	}
}