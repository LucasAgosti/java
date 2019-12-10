package com.poogametopview.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.poogametopview.entities.Ammo;
import com.poogametopview.entities.Boss;
import com.poogametopview.entities.Enemy;
import com.poogametopview.entities.Enemy2;
import com.poogametopview.entities.Entity;
import com.poogametopview.entities.Item;
import com.poogametopview.entities.Pistol;
import com.poogametopview.entities.Player;
import com.poogametopview.entities.Weapon;
import com.poogametopview.graphics.Spritesheet;
import com.poogametopview.main.Game;

public class World {
	
	public static Tile[] tiles;
	public static int WIDTH, HEIGHT;
	public static final int TILE_SIZE = 16;
	
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
					
					tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR);
					if(pixelAtual == 0xFF000000) {
						//PRETO = CHÃO
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR);
						
					}else if(pixelAtual == 0xFFFFFFFF) {
						//BRANCO = PAREDES
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_WALL);
						
					}else if(pixelAtual == 0xFF0026FF) {
						//AZUL = PLAYER SPAWN
						Game.player.setX(xx * 16);
						Game.player.setY(yy * 16);
						
					}else if(pixelAtual == 0xFFFF0000){
						//VERMELHO = ENEMY
						Enemy en = new Enemy(xx * 16, yy * 16, 16, 16, Entity.ENEMY_EN);
						Game.entities.add(en);
						Game.enemies.add(en); //CRIAR OUTRA LISTA SÓ COM INIMIGOS PARA CONFERIR AS COLIÇÕES
						
					}else if(pixelAtual == 0xFF00FF21) {
						//VERDE = CURA
						Item pack = new Item(xx * 16, yy * 16, 16, 16, Entity.LIFEPACK_EN);
						//pack.setMask(12, 12, 12, 12);
						Game.entities.add(pack);
					}else if(pixelAtual == 0xFFFF006E) {
						//ROSA = ARMA
						Game.entities.add(new Weapon(xx * 16, yy * 16, 16, 16, Entity.GUN_EN));
					
					}else if(pixelAtual == 0xFFFFD800) {
						//AMARELO = MUNIÇÃO
						Game.entities.add(new Ammo(xx * 16, yy * 16, 16, 16, Entity.WEAPONAMMO_EN));
					}else if(pixelAtual == 0xFF7F0000){
						//VERMELHO ESCURO = ENEMY2
						Enemy2 en2 = new Enemy2(xx * 16, yy * 16, 16, 16, Entity.ENEMY2_EN);
						Game.entities.add(en2);
						Game.enemies2.add(en2); //CRIAR OUTRA LISTA SÓ COM INIMIGOS PARA CONFERIR AS COLIÇÕES
						
					}else if(pixelAtual == 0xFF404040){
						//CINZA = BOSS
						Boss b = new Boss(xx * 16, yy * 16, 16, 16, Entity.BOSS_EN);
						Game.entities.add(b);
						Game.boss.add(b); //CRIAR OUTRA LISTA SÓ COM BOSS PARA CONFERIR AS COLIÇÕES
						
					}else if(pixelAtual == 0xFF00FFFF) {
						//AZUL CLARO = PISTOLA PRATA
						Game.entities.add(new Pistol(xx * 16, yy * 16, 16, 16, Entity.PISTOL_EN));
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
	
	public static boolean isFree(int xNext, int yNext) {
		int x1 = xNext / TILE_SIZE;
		int y1 = yNext / TILE_SIZE;
		
		int x2 = (xNext + TILE_SIZE - 1) / TILE_SIZE;
		int y2 = yNext / TILE_SIZE;
		
		int x3 = xNext / TILE_SIZE;
		int y3 = (yNext + TILE_SIZE - 1) / TILE_SIZE;
		
		int x4 = (xNext + TILE_SIZE - 1) / TILE_SIZE;
		int y4 = (yNext + TILE_SIZE - 1) / TILE_SIZE;
		
		return !((tiles[x1 + (y1 * World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2 * World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3 * World.WIDTH)] instanceof WallTile) ||
				(tiles[x4 + (y4 * World.WIDTH)] instanceof WallTile));
	}
	
	public static void restartGame(String level) {

		Game.entities.clear();
		Game.enemies.clear();
		Game.enemies2.clear();
		Game.boss.clear();
		Game.entities = new ArrayList<Entity>();
		Game.enemies = new ArrayList<Enemy>();
		Game.enemies2 = new ArrayList<Enemy2>();
		Game.boss = new ArrayList<Boss>();
		Game.spritesheet = new Spritesheet("/spritesheet.png");
		
		Game.player = new Player(0, 0, 16, 16, Game.spritesheet.getSprite(32, 0, 16, 16));
		Game.entities.add(Game.player);
		Game.world = new World("/level" + Game.curLevel + ".png");
		return;
	}
	
	public void render(Graphics gph) {
		
		int xStart = Camera.x / 16;
		int yStart = Camera.y / 16;
		//16 pois é o tamanho dos tiles
		int xEnd = xStart + (Game.WIDTH / 16);
		int yEnd = yStart + (Game.HEIGHT / 16);
		
		for(int xx = xStart; xx <= xEnd; xx++) {
			for(int yy = yStart; yy <= yEnd; yy++) {
				
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy * WIDTH)];
				tile.render(gph);
			}
		}
	}
}