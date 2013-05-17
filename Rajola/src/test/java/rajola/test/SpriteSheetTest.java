package rajola.test;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import rajola.pipeline.TileSpriteSheet;

public class SpriteSheetTest extends BasicGame {

	private TileSpriteSheet spriteSheet;

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
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		spriteSheet = new TileSpriteSheet("res/test.png", 16);
	}

	@Override
	public void update(GameContainer gc, int DELTA) throws SlickException {
		
	}
}
