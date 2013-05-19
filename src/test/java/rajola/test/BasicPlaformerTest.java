package rajola.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import rajola.pipeline.BasicTile;
import rajola.pipeline.TileMap;
import rajola.pipeline.TileMapLayer;
import rajola.pipeline.sprites.SpriteSheet;

public class BasicPlaformerTest extends BasicGame {

	final static int TILE_SIZE = 32;
	
	protected SpriteSheet spriteSheet;
	protected TileMap map;
	
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
		map.update(gc, d);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		spriteSheet = new SpriteSheet("res/tileset.jpg", TILE_SIZE);
		map = new TileMap();
		map.fillBackgroundLayer(spriteSheet.getTileSprite(1, 0), 20, 15);
		
		TileMapLayer firstLayer = new TileMapLayer(1, "Platforms");
		
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(5, 7)), 1, 6);
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(6, 7)), 2, 6);
		firstLayer.addTile(new BasicTile(0,spriteSheet.getTileSprite(7, 7)), 3, 6);
		
		map.addLayer(firstLayer);
		
	}
	
}
