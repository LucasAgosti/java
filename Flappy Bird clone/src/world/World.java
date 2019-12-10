package world;

import entities.Player;
import main.Game;

public class World {

	public static void restartGame(){
		
		Game.score = 0;
		Game.player = new Player(Game.WIDTH/2 - 30, Game.HEIGHT/2, 16, 16, 2, Game.spritesheet.getSprite(0, 0,16,16));
		Game.entities.clear();
		Game.entities.add(Game.player);
		return;
	}	
}