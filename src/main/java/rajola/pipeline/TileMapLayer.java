package rajola.pipeline;

import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import rajola.pipeline.tools.Renderable;

/**
 * 
 * @author Frédéric-Antoine Gingras
 *
 * The TileMapLayer class represents a tile map layer of rendering this offers
 * the flexibility to overlay different TileSprite, e.g.: a background layer has
 * the "decor" and specific objects like Rocks, Chests, etc. are on an other Layer.
 * 
 * It has a name, a priority, and it's tiles
 *
 */
public class TileMapLayer implements Renderable {
	
	private static int nextId = 1;
	
	private Integer id;
	private Integer importance;
	private String name;
	private Tile[][] tiles;
	
	public TileMapLayer(){
		this.id = nextId;
		nextId++;
	}
	public TileMapLayer(Integer importance, String name){
		this();
		this.setImportance(importance);
		this.name = name;
	}
	public TileMapLayer(Tile[][] tiles){
		this();
		this.tiles = tiles;
	}
	public TileMapLayer(Integer importance, String name, Tile[][] tiles){
		this(importance, name);
		this.tiles = tiles;
	}
	
	public void addTile(Tile tile, int x, int y){
		ensureTilesSize(x, y);
		tiles[x][y] = tile;
	}
	
	private void ensureTilesSize(int x, int y){
		if (tiles.length < x)
			tiles = Arrays.copyOf(tiles, x);
		if (tiles[x].length < y)
			tiles[x] = Arrays.copyOf(tiles[x], y);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
	}
	@Override
	public void update(GameContainer gc, int d) throws SlickException {
		
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the importance
	 */
	public Integer getImportance() {
		return importance;
	}
	/**
	 * @param importance the importance to set
	 */
	public void setImportance(Integer importance) {
		this.importance = importance;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the tiles
	 */
	public Tile[][] getTiles() {
		return tiles;
	}
	/**
	 * @param tiles the tiles to set
	 */
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	
}
