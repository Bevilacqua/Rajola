package rajola.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import rajola.pipeline.BasicTile;
import rajola.pipeline.Tile;
import rajola.pipeline.level.TileMap;
import rajola.pipeline.level.TileMapLayer;
import rajola.pipeline.sprites.TileSprite;
import rajola.pipeline.sprites.TileSpriteSheet;

public class BasicPlaformerTest extends BasicGame {

	final static int TILE_SIZE = 32;
	
	protected TileSpriteSheet spriteSheet;
	protected TileMap map;
	Tile animatedTile;

	private TileSprite animatedSprite;
	
	public BasicPlaformerTest() {
		super("Rajola - Basic platformer integration test");
	}
	
	public static void main(String args[]) throws SlickException {
		AppGameContainer gc = new AppGameContainer(new BasicPlaformerTest());
		gc.setDisplayMode(20*TILE_SIZE, 15*TILE_SIZE, false);
		gc.start();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		map.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, int d) throws SlickException {
		animatedTile.update(d);
		map.update(gc, d);
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		spriteSheet = new TileSpriteSheet("res/tileset.jpg", TILE_SIZE);
		map = new TileMap();
		map.fillBackgroundLayer(spriteSheet.getTileSprite(1, 0), 20, 15);
		TileMapLayer firstLayer = new TileMapLayer(1, "Platforms");
		map.addLayer(firstLayer);
		Image tiles[][] = new Image[][] {{spriteSheet.getTileImage(7, 1) , spriteSheet.getTileImage(8, 1)}};
		animatedSprite = new TileSprite(1000 , tiles);
		animatedTile = new BasicTile(1 , animatedSprite);
		
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(5, 7)), 0, 6);
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(6, 7)), 1, 6);
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(7, 7)), 2, 6);
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 15-6; y++){
				firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(9, 4)), x, 7 + y);
			}
		}

		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(5, 7)), 4, 8);
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(6, 7)), 5, 8);
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(7, 7)), 6, 8);
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 15-8; y++){
				firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(9, 4)), 4+x, 9 + y);
			}
		}

		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(5, 7)), 8, 8);
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(6, 7)), 9, 8);
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(7, 7)), 10, 8);
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 15-8; y++){
				firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(9, 4)), 8+x, 9 + y);
			}
		}
		

		TileMapLayer fgLayer = new TileMapLayer(0, "Forground");
		map.addLayer(fgLayer);
		
		for (int i = 0; i < 20; i++){
			fgLayer.addTile(animatedTile, i, 13);
			fgLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(9, 2)), i, 14);
		}
		
		
	}
	
}
