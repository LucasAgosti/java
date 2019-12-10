package world;

import entities.Entity;
import entities.Tube;
import main.Game;

public class TubeGenerator {

	public int time = 0;
	public int maxTime = 120;
	
	public void tick() {
		
		time++;
		if(time == maxTime) {
			//CRIA UM NOVO TUBO E O CONTADOR É RESETADO
			
			int alturaTuboCima = Entity.rand.nextInt(50 - 30) + 40;
			Tube tuboCima = new Tube(Game.WIDTH, 0, 32, alturaTuboCima, 1, Game.spritesheet.getSprite(16 * 3, 16 * 2, 32, 32));
			Game.entities.add(tuboCima);
			
			int alturaTuboBaixo = Entity.rand.nextInt(50 - 30) + 40;
			Tube tuboBaixo = new Tube(Game.WIDTH, Game.HEIGHT - alturaTuboBaixo, 32, alturaTuboBaixo, 1, Game.spritesheet.getSprite(16 * 0, 16 * 2, 32, 32));
			Game.entities.add(tuboBaixo);
			
			time = 0;
		}
		
	}	
}