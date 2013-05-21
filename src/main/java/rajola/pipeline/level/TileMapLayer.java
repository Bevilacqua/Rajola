package rajola.pipeline.level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import rajola.pipeline.Tile;
import rajola.pipeline.tools.Renderable;

/**
 * 
 * @author Frederic-Antoine Gingras
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
		tiles = new Tile[0][0];
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
		this.tiles[x][y] = tile;
	}
	
	private void ensureTilesSize(int x, int y){
		Tile[][] oldTiles = this.tiles;
		int maxX = x > oldTiles.length ? x : oldTiles.length;
		int maxY = oldTiles.length == 0 || y > oldTiles[0].length ? y : oldTiles[0].length;
		this.tiles = new Tile[maxX+1][maxY+1];
		for (int lx = 0; lx < oldTiles.length; lx++){
			for (int ly = 0; ly < oldTiles[lx].length; ly++){
					this.tiles[lx][ly] = oldTiles[lx][ly];
			}
		}
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int x = 0; x < tiles.length; x++){
			for (int y = 0; y < tiles[x].length; y++){
				if (tiles[x][y] != null)
					tiles[x][y].render(
							x*tiles[x][y].getSprite().getWidth(), 
							y*tiles[x][y].getSprite().getHeight()
						);
			}
		}
	}
	@Override
	public void update(GameContainer gc, int d) throws SlickException {
		for (int x = 0; x < tiles.length; x++){
			for (int y = 0; y < tiles[x].length; y++){
				if (tiles[x][y] != null)
					tiles[x][y].update(d);
			}
		}
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
