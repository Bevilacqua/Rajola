package rajola.pipeline.tools;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * @author Kiasaki
 */
public interface Renderable {

	public void render(GameContainer gc, Graphics g) throws SlickException;

	public void update(GameContainer gc, int d) throws SlickException;
	
}
