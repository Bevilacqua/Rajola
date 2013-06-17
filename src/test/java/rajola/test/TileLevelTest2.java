package rajola.test;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import rajola.pipeline.BasicTile;
import rajola.pipeline.Tile;
import rajola.pipeline.level.TileLevel;
import rajola.pipeline.sprites.TileSprite;
import rajola.pipeline.sprites.TileSpriteSheet;

public class TileLevelTest2 extends BasicGame {

	private TileSpriteSheet sheet;
	private Tile animatedTile;
	private Tile tile1 , tile2;
	private Tile nullTile;
	private List<Image> animatedTileImages = new ArrayList();
	private TileLevel level;
	private TileSpriteSheet nullSheet;
	private int x;
	private int y;
	
	public TileLevelTest2() {
		super("TileLevelTest");
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		level.Render();
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		sheet = new TileSpriteSheet("res/LouTestSpriteSheet.png" , 16);
		nullSheet = new TileSpriteSheet("res/nullTile.png" , 16);
		animatedTileImages.add(sheet.getTileImage(0, 0));
		animatedTileImages.add(sheet.getTileImage(0, 1));
		animatedTile = new BasicTile(0 , new TileSprite(1000 , animatedTileImages) , 0x000000);
		tile1 = new BasicTile(1 , new TileSprite(sheet.getTileImage(1, 0)) , 0xFFFFFF);
		tile2 = new BasicTile(2 , new TileSprite(sheet.getTileImage(1, 1)) , 0xFF0000);
		nullTile = new BasicTile(3 , new TileSprite(nullSheet.getTileImage(0, 0)) , 0xF0F0F0);
		
		Tile tileSet[] = {animatedTile , tile1 , tile2};
		
		level = new TileLevel(tileSet , "res/LouTestMap.png" , nullTile);

	}

	@Override
	public void update(GameContainer gc, int DELTA) throws SlickException {
		Input input = gc.getInput();
		level.Update(DELTA, x, y);
		
		if(input.isKeyDown(Input.KEY_LEFT) && x < 0) x+=4;
		if(input.isKeyDown(Input.KEY_RIGHT) && x > -512) x-=4;
		if(input.isKeyDown(Input.KEY_DOWN) && y > -512) y-=4;
		if(input.isKeyDown(Input.KEY_UP) && y < 0) y+=4;
		System.out.println(x + " | " + y);
	}
	
	public static void main(String args[]) throws SlickException {
		AppGameContainer apg = new AppGameContainer(new TileLevelTest2());
		apg.setShowFPS(false);
		apg.setDisplayMode(512, 512, false);
		apg.start();
		
	}
}
