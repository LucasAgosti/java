package com.poogametopview.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Menu {

	public String[] options = {"New Game", "Load Game", "Exit"};
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up, down, enter;
	public boolean pause = false;
	
	public void tick() {
		
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0) 
				currentOption = maxOption;
			
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption) 
				currentOption = 0;
		}
		if(enter) {
			enter = false;
			
			if(options[currentOption] == "New Game" || options[currentOption] == "Resume Game") {
				Game.gameState = "NORMAL";
				pause = false;
				
			}else if(options[currentOption] == "Exit")
				System.exit(1);
		}
	}
	
	public void render(Graphics gphs) {
		
		//BACKGROUND MENU
		Graphics2D gphs2 = (Graphics2D) gphs;
		gphs2.setColor(new Color(0, 0, 0 ,170));
	
		gphs2.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		
		//TITULO MENU
		gphs.setColor(Color.white);
		gphs.setFont(new Font("arial", Font.BOLD, 36));
		gphs.drawString(">The legend of Joe<", (Game.WIDTH * Game.SCALE) / 4 + 60 , (Game.HEIGHT * Game.SCALE) / 5 );
		
		gphs.setColor(Color.white);
		gphs.setFont(new Font("arial", Font.BOLD, 18));
		gphs.drawString("version 1.0.0", 10, (Game.HEIGHT * Game.SCALE) - 10 );
		
		//OPÇÕES MENU
		gphs.setColor(Color.white);
		gphs.setFont(new Font("arial", Font.BOLD, 28));
		
		if(pause == false) 
			gphs.drawString("New Game", ((Game.WIDTH * Game.SCALE) / 4) + (Game.WIDTH * Game.SCALE) / 10, ((Game.HEIGHT * Game.SCALE) / 3) + (Game.HEIGHT * Game.SCALE / 8));
		else
			gphs.drawString("Resume Game", ((Game.WIDTH * Game.SCALE) / 4) + (Game.WIDTH * Game.SCALE) / 10, ((Game.HEIGHT * Game.SCALE) / 3) + (Game.HEIGHT * Game.SCALE / 8) );
		gphs.drawString("Load Game", ((Game.WIDTH * Game.SCALE) / 4) + (Game.WIDTH * Game.SCALE) / 10, ((Game.HEIGHT * Game.SCALE) / 3) + (Game.HEIGHT * Game.SCALE) / 4);
		gphs.drawString("Exit", ((Game.WIDTH * Game.SCALE) / 4) + (Game.WIDTH * Game.SCALE) / 10, ((Game.HEIGHT * Game.SCALE) / 2) + (Game.HEIGHT * Game.SCALE) / 3);
		
		if(options[currentOption] == "New Game" || options[currentOption] == "Resume Game") {
			gphs.drawString(">", 100, ((Game.HEIGHT * Game.SCALE) / 3) + (Game.HEIGHT * Game.SCALE / 8));
			
		}else if(options[currentOption] == "Load Game") {
			gphs.drawString(">", 100, ((Game.HEIGHT * Game.SCALE) / 3) + (Game.HEIGHT * Game.SCALE) / 4);
			
		}else if(options[currentOption] == "Exit") {
			gphs.drawString(">", 100, ((Game.HEIGHT * Game.SCALE) / 2) + (Game.HEIGHT * Game.SCALE) / 3);
			
		}
	}
}
