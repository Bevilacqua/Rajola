package rajola.pipeline.level;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import rajola.pipeline.Tile;

/**
 * 
 * @author Jacob Bevilacqua
 *
 *The TileLevel class provides an alternative to hardcoding tiles into a map
 *TileLevel generates a level from an image and then renders them onto the screen
 *TileLevel does not handle entity loading or entity rendering
 *
 */

public class TileLevel {
int screenHeight;
int screenWidth;

String mapImagePath;
int mapImageHeight;
int mapImageWidth;
Image mapImage;
int[] pixelsOnMapImage; //The pixels of mapImage

List<Tile> tileSet = new ArrayList<Tile>(); //Collection of tiles to be used
Tile nullTile; //This is not to be used anywhere but the constructor use the tile list instead to access this tile
int nullTileID; //the tileID of the nullTile
	
	public TileLevel(Tile[] tileSet , int screenHeight , int screenWidth , String mapImagePath , Tile nullTile) {
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		
		this.nullTile = nullTile;
		
		for(int i = 0 ; i < tileSet.length ; i++) {
			this.tileSet.add(tileSet[i]);
		}
		//The next three lines set the null tile's id to one larger than the last tile in the tileSet then adds the null tile to the tileSet
		this.nullTile.setId((this.tileSet.size() + 1));
		this.nullTileID = (nullTile.getId());
		this.tileSet.add(nullTile);
		this.mapImagePath = mapImagePath;
		loadImage(this.mapImagePath);
	}

	private void loadImage(String mapImagePath) {
		try {
			this.mapImage = new Image(mapImagePath);
			this.mapImageHeight = this.mapImage.getHeight();
			this.mapImageWidth = this.mapImage.getWidth();
			this.pixelsOnMapImage = new int[this.mapImageHeight * this.mapImageWidth];
		} catch (SlickException e) {
			e.printStackTrace();
		}
		//Populates pixelsOnMapImage with rgb data from mapImage
		for(int y = 0 ; y < this.mapImageHeight ; y++) {
			for(int x = 0 ; x < this.mapImageWidth ; x++) {
				int rgb = this.mapImage.getColor(x, y).getRed();
				rgb = (rgb << 8) + this.mapImage.getColor(x, y).getGreen();
				rgb = (rgb << 8) + this.mapImage.getColor(x, y).getBlue();
				this.pixelsOnMapImage[x + y * this.mapImageWidth] = rgb;
			}
		}
	}
}