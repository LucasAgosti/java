package com.poogametopview.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.poogametopview.entities.Player;
import com.poogametopview.main.Game;

public class UI {

	public void render(Graphics gphs) {
		
		//HP UI
		gphs.setColor(Color.red);
		gphs.fillRect(10, 4, 70, 8);
		
		gphs.setColor(Color.ORANGE);
		gphs.fillRect(10, 4, (int)((Game.player.life / Game.player.maxLife) * 70), 8);
		
		gphs.setFont(new Font("arial", Font.BOLD, 8));
		gphs.setColor(Color.white);
		gphs.drawString("HP: " + (int)Game.player.life + "/" + (int)Game.player.maxLife, 12, 11);
			
	}
	
	
}
