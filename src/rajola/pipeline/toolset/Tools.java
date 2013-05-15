package rajola.pipeline.toolset;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

public class Tools {

	public static Image toSlickImage(BufferedImage image) { //BufferedImage to SlickImage
		Texture tex = null;
		try {
			tex = BufferedImageUtil.getTexture("Blank Hold", image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Image(tex);
	}
	
}
