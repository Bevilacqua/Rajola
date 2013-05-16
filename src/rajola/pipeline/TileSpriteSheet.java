package rajola.pipeline;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;

import rajola.pipeline.tools.ImageTools;

public class TileSpriteSheet {
	
	private String path;
	private int size; //Width = Height = size
	private int tileSize;

	private int pixels[];
    private List<Image> tilesImages;
    
    private BufferedImage bImage;
    private int[] bPixels;
	
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
		
		//TODO: Test this because its confusing me :)
		for(int y = 0 ; y < this.size ; y++) {
			for(int x = 0 ; x < this.size ; x++) {
				bImage = new BufferedImage(this.tileSize , this.tileSize , BufferedImage.TYPE_INT_RGB);
				bPixels = ((DataBufferInt) bImage.getRaster().getDataBuffer()).getData();
				for(int localY = 0 ; localY < this.tileSize ; localY++ ) {
					for(int localX = 0 ; localX < this.tileSize ; localX++) {
						bPixels[localX * localY] = pixels[(x + localX) * (y + localY)];
						x++;
					}
					y++;
				}
				this.tilesImages.add(ImageTools.toSlickImage(bImage));
			}
		}
	}
	
	public List<Image> getTiles() {
		if(this.tilesImages !=null) return this.tilesImages;
		else throw new NullPointerException(); //This may be a little much...
	}
	
}
