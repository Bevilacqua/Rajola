package rajola.pipeline.tools;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

import rajola.pipeline.Tile;

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
	
	public static int shiftCounter(int original) {
		int hold = original;
		int shifts = 0;
		for(shifts = 0 ; shifts < original ; shifts++ ) {
			hold /= 2;
			if(hold <= 1) {
				shifts++;
				return shifts; 
			}
		}
		return -1; //Error
	}
	
}
