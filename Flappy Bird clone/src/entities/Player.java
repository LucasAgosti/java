package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import world.Camera;
import world.World;


public class Player extends Entity{
	
	public boolean isPressed = false;
	private int frames = 0, maxFrames = 20, index = 0, maxIndex = 3;
	
	private BufferedImage[] bird;
	
	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
		
		bird = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			bird[i] = Game.spritesheet.getSprite(16 * 0 + (i * 16), 16 * 0, 16, 16);
		}
	}
	
	public void tick(){
		
		depth = 1;
		
		if(!isPressed) {
			
			y += 0.8;
		}else {
			y -= 0.8;
		}
			
		if(y > Game.HEIGHT) {
			World.restartGame();
		}
		
		frames++;
		
		if(frames == maxFrames) {
			frames = 0;
			index++;
			if(index > maxIndex) {
				index = 0;
			}
		}
		
		//TESTANDO COLISÃO
		for(int i = 0; i < Game.entities.size(); i++) {
			
			Entity e = Game.entities.get(i);
			if(e != this) {
				
				if(Entity.isColidding(this, e)) {
					//GAME OVER
					World.restartGame();
					return;
				}
			}	
		}
	}
	
	public void render(Graphics g) {
		if(!isPressed) {
			
			g.drawImage(bird[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}else {
			g.drawImage(bird[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
		}	
	}
}
