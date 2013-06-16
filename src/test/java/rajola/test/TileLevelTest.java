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

public class TileLevelTest extends BasicGame {

	private TileLevel level;
	private TileSpriteSheet spriteSheet;
	private TileSprite animatedSprite;
	private TileSprite sprite1;
	private TileSprite sprite2;
	private BasicTile animatedTile;
	private BasicTile tile1;
	private BasicTile tile2;
	private List<Image> images = new ArrayList();
	private int x,y;
	private BasicTile nullTile;
	private TileSpriteSheet nullspriteSheet;
	public TileLevelTest() {
		super("Rajola | TileLevelTest");
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		level.Render();
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		spriteSheet = new TileSpriteSheet("res/testing.png", 8);
		nullspriteSheet = new TileSpriteSheet("res/nullTile.png" , 8);
		images.add(spriteSheet.getTileImage(0, 0));
		images.add(spriteSheet.getTileImage(0, 1));
		animatedTile = new BasicTile( 0 , new TileSprite(1000 , images) , 0xFFFFFF);
		tile1 = new BasicTile(1 , new TileSprite(spriteSheet.getTileImage(1, 0)) , 0xFF0000);
		tile2 = new BasicTile(2 , new TileSprite(spriteSheet.getTileImage(1,1)), 0x000000);
		nullTile = new BasicTile(3 , new TileSprite(spriteSheet.getTileImage(0, 0)) , 0xAAAAAA);
		
		Tile tiles[] = { animatedTile, tile1 , tile2};


		level = new TileLevel(tiles , 256 , 256 , "res/levelTest.png" , nullTile);
	}

	@Override
	public void update(GameContainer gc, int DELTA) throws SlickException {
		Input input= gc.getInput();
		level.Update(DELTA, 0, 0);
		if(input.isKeyPressed(Input.KEY_W) == true) {
			this.x--;
			this.y--;
		}

	}
	
	public static void main(String args[]) throws SlickException {
		AppGameContainer apg = new AppGameContainer(new TileLevelTest());
		apg.setDisplayMode(256, 256, false);
		apg.start();
	}

}
