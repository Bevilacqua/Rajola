package rajola.pipeline.level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import rajola.pipeline.BasicTile;
import rajola.pipeline.Tile;
import rajola.pipeline.sprites.TileSprite;
import rajola.pipeline.tools.Renderable;

/**
 * The TileMap class holds a collection of all the tiles on the map and their positions, ids, attributes
 * It's has multiple functions to ease map creation programaticly.
 *
 * @author Frederic-Antoine Gingras
 */
public class TileMap implements Renderable {

	private List<TileMapLayer> layers; 
	
	public TileMap(){
		layers = new ArrayList<TileMapLayer>();
	}
	/**
	 * @param tiles pre-fills the tiles of the TileMap
	 */
	public TileMap(List<TileMapLayer> layers){
		this();
		this.layers = layers;
	}
	
	/**
	 * @param layer the layer to add to the map
	 */
	public void addLayer(TileMapLayer layer){
		this.layers.add(layer);
	}
	
	/**
	 * Fills a background layer with a specified sprite and sets it a low importance
	 * @param bgTile
	 * @param width
	 * @param height
	 */
	public void fillBackgroundLayer(TileSprite bgTile, int width, int height){
		// Instantiate that new layer
		TileMapLayer tLayer = new TileMapLayer(-1, "Background");
		// Tile to use for filling
		Tile tile = new BasicTile(0, bgTile, false);
		Tile[][] tiles = new Tile[width][height];
		// Loop and fill the layer with specified sprite
		for (int i = 0; i < width; i++){
			Arrays.fill(tiles[i], tile);
		}
		tLayer.setTiles(tiles);
		layers.add(tLayer);
	}
	
	public TileMapLayer[] getLayersOrderedByImportance(){
		TileMapLayer[] orderedLayers = layers.toArray(new TileMapLayer[layers.size()]);
		Arrays.sort(orderedLayers, new Comparator<TileMapLayer>(){
			@Override
			public int compare(TileMapLayer a, TileMapLayer b) {
				return a.getImportance().compareTo(b.getImportance());
			}
		});
		return orderedLayers;
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (TileMapLayer tileMapLayer : getLayersOrderedByImportance()) {
			tileMapLayer.render(gc, g);
		}
	}
	@Override
	public void update(GameContainer gc, int d) throws SlickException {
		for (TileMapLayer tileMapLayer : getLayersOrderedByImportance()) {
			tileMapLayer.update(gc, d);
		}
	}
	
}
