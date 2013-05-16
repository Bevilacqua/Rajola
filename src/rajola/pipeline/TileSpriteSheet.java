package rajola.pipeline;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;

public class TileSpriteSheet {
	
	private String path;
	private int size; //Width = Height = size
	private int tileSize;

	private int pixels[];
    private List<Image> tilesImages;
	
	/**
	 * @param path the path to the sprite sheet
	 * @param size the size of the sprite sheet, the sprite sheet must have an equal height and width
	 */
	public TileSpriteSheet(String path , int size) {
		this.size = size;
		this.path = path;
		pixels = new int[this.size * this.size];
		loadSpriteSheetImage();
	}
	
	/**
	 * this constructor will produce an array of slick images each the size of one tile
	 * @param path the path to the sprite sheet
	 * @param size the size of the sprite sheet, the sprite sheet must have an equal height and width
	 * @param tileSize the size of the tiles
	 */
	public TileSpriteSheet(String path , int size , int tileSize) {
		this.size = size;
		this.path = path;
		this.tileSize = tileSize;
		pixels = new int[this.size * this.size];
		loadSpriteSheetImage();
		organizeImages();
	}
	
	/*
	 * Load the spritesheet and store the pixel data in pixels array
	 */
	private void loadSpriteSheetImage() {
		
		try {
			BufferedImage image = ImageIO.read(TileSpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void organizeImages() {
		if(tileSize <= 0 ) return;
		
		for(int i = 0; i <= this.pixels.length ; i++) {
			//TODO:run through pixels array and save pixels into new image use a BufferedImage and raster to write to then convert to slickImage
			
		}
	}
	
}
