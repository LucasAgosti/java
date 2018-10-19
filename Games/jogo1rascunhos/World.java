package com.gametopview.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class World {
	
	private Tile[] tiles;
	public static int WIDTH, HEIGHT;
	
	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			
			for(int xx = 0; xx < map.getWidth(); xx++) {
				for(int yy = 0; yy < map.getHeight(); yy++) {
					
					int pixelAtual =  pixels[xx + (yy * map.getWidth())];
					
					if(pixelAtual == 0xFF000000) {
						//PRETO = CHÃO
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR);
						
					}else if(pixelAtual == 0xFFFFFFFF) {
						//BRANCO = PAREDES
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_WALL);
						
					}else if(pixelAtual == 0xFF0026FF) {
						//AZUL = PLAYER SPAWN
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR);
						
					}else {
						//CHÃO
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR);
					}
				}
				
			}
			/*for(int i = 0; i < pixels.length; i++) {
				if(pixels[i] == 0xFFFF0000) {
					System.out.println("PIXEL VERMELHO");
					
				}else if(pixels[i] == 0xFFFFD800) {
					System.out.println("PIXEL AMARELO");
					
				}else if(pixels[i] == 0XFF00FF21) {
					System.out.println("PIXEL VERDE");
					
				}else if(pixels[i] == 0xFFFF006E) {
					System.out.println("PIXEL ROSA");
				}	
			}*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void render(Graphics gph) {
		
		for(int xx = 0; xx < WIDTH; xx++) {
			for(int yy = 0; yy < HEIGHT; yy++) {
				
				Tile tile = tiles[xx + (yy * WIDTH)];
				tile.render(gph);
			}
		}
	}
}
