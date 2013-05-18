package rajola.pipeline;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import rajola.pipeline.tools.Renderable;
import sun.tools.tree.OrExpression;

/**
 * 
 * @author Frédéric-Antoine Gingras
 *
 * The TileMap class holds a collection of all the tiles on the map and their positions, ids, attributes
 * It's has multiple functions to ease map creation programaticly.
 *
 */
public class TileMap implements Renderable {

	private List<TileMapLayer> layers; 
	
	public TileMap(){
		
	}
	/**
	 * @param tiles pre-fills the tiles of the TileMap
	 */
	public TileMap(List<TileMapLayer> layers){
		this.layers = layers;
	}
	
	/**
	 * @param layer the layer to add to the map
	 */
	public void addLayer(TileMapLayer layer){
		this.layers.add(layer);
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
