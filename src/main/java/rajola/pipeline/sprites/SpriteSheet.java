package rajola.pipeline.sprites;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpriteSheet {

	private String path;
	private int tileSize;
    private Image[][] tileImages;
    private Image fullImage;
	
    /**
     * @param path path to the image
     * This constructor does not create array of tiles
     */
	public SpriteSheet(String path) {
		this.path = path;
		
		try {
			fullImage = new Image(path);
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
    
    /**
	 * @param path the path to the sprite sheet
	 * @param size the size of the sprite sheet, the sprite sheet must have an equal height and width
	 */
	public SpriteSheet(String path , int tileSize) {
		this.tileSize = tileSize;
		this.path = path;

		// Load the full image so we can split it up in tiles
		Image completeImage = null;
		try {
			completeImage = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		// Instantiate our array the right size
		tileImages = new Image[completeImage.getWidth()/tileSize][completeImage.getHeight()/tileSize];
		
		// Assign each Image in our array to a sub-part of the complete tileset
		for (int x = 0; x < tileImages.length; x++){
			for (int y = 0; y < tileImages[x].length; y++) {
				tileImages[x][y] = completeImage.getSubImage(x * tileSize, y * tileSize, tileSize, tileSize);
			}
		}
	}
	
	/**
	 * @return List of images containing individual tiles
	 */
	public Image[][] getTiles() {
		return this.tileImages;
	}
	
	/*
	 * @return Width of the tile set in tiles
	 */
	public int getTileWidth() {
		return this.tileImages.length;
	}
	
	/*
	 * @return Height of the tile set in tiles
	 */
	public int getTileHeight() {
		return this.tileImages[0].length;
	}
	
	/*
	 * @return Width of the tile set in pixels
	 */
	public int getWidth() {
		return this.getTileWidth()*this.tileSize;
	}
	
	/*
	 * @return Width of the tile set in pixels
	 */
	public int getHeight() {
		return this.getTileHeight()*this.tileSize;
	}
	
	/*
	 * @return Image at specified index
	 */
	public Image getTileImage(int x, int y) {
		return tileImages[x][y];
	}
	
	/*
	 * @return The tile set path
	 */
	public String getPath() {
		return this.path;
	}

	public Image getFullImage() {
		return fullImage;
	}

}
