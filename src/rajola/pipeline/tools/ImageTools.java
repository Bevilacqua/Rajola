package rajola.pipeline.tools;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

public class ImageTools {

	//All Tools should be referenced in a static manor
	
	/**
	 * @param BufferedImage
	 * @return Slick Image
	 */
	public static Image toSlickImage(BufferedImage image) {
		Texture tex = null;
		try {
			tex = BufferedImageUtil.getTexture("Blank Hold", image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Image(tex);
	}
	
}
