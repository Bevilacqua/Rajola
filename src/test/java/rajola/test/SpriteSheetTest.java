package rajola.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import rajola.pipeline.TileSpriteSheet;
import rajola.pipeline.sprites.TileSprite;

public class SpriteSheetTest extends BasicGame {

	private TileSpriteSheet spriteSheet;
	private TileSpriteSheet spriteSheet2;
	private TileSprite sprite;

	public SpriteSheetTest() {
		super("Rajola| SPRITE SHEET TEST");
	}

	public static void main(String args[]) throws SlickException {
		AppGameContainer gc = new AppGameContainer(new SpriteSheetTest());
		gc.setDisplayMode(600, 800, false);
		gc.start();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		int yOffset = 50;
		int xOffset = 50;
		for (int i = 0; i < 4; i++) {
			spriteSheet.getTileImage(i % 2, (int)Math.floor(i / 2)).draw((i * 40) + xOffset , yOffset);
		}
		spriteSheet2.getFullImage().draw(100 ,100);
		sprite.drawSprite(100, 150);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		spriteSheet = new TileSpriteSheet("res/test.png", 16);
		spriteSheet2 = new TileSpriteSheet("res/test.png");
		sprite = new TileSprite(spriteSheet2.getFullImage());
	}

	@Override
	public void update(GameContainer gc, int DELTA) throws SlickException {
		
	}
}
