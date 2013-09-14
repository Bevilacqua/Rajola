package rajola.pipeline;

import rajola.pipeline.sprites.TileSprite;

public abstract class Tile {

	private int id;
	private boolean solid;
	private TileSprite sprite;
	private int elapsedTime;
	private int mapColor; //a map color of -1 signifies the use of TileMap, TileMapLayer instead of TileLevel
	private int size; //Tiles must be a square
	
	public Tile(int id ,TileSprite sprite) {
		this.id = id;
		this.solid = false;
		this.sprite = sprite;
		this.mapColor = -1;
		this.size = sprite.getHeight();
	}
	
	public Tile(int id ,TileSprite sprite , boolean solid) {
		this.id = id;
		this.sprite = sprite;
		this.solid = solid;
		this.mapColor = -1;
		this.size = sprite.getHeight();
	}
	
	public Tile(int id , TileSprite sprite , boolean solid , int mapColor) {
		this(id , sprite , solid);
		this.mapColor = mapColor;
	}
	
	public Tile(int id , TileSprite sprite , int mapColor) {
		this(id , sprite);
		this.mapColor = mapColor;
		this.size = sprite.getHeight();
	}
	
	/**
	 * @param x the location to draw the tile
	 * @param y the location to draw the tile
	 * Render the tile at the specified location.
	 * Not to be called directly by the developer.
	 */
	public void render(int x , int y) {
		sprite.render(x, y);
	} 
	
	/**
	 * @param delta the delta variable to be used in animation
	 * Update the tile's animation loop
	 */
	public void update(int delta) {		
		if(elapsedTime < this.sprite.getAnimationSpeed()) {
			elapsedTime += delta;
		} else {
			if(this.sprite.getCurrentFrame() < this.sprite.getFrames().size() - 1) this.sprite.incrementFrame();
			else this.sprite.setCurrentFrame(0);
			elapsedTime = 0;
		}
	}
	
	/**
	 * @return the tiles id;
	 * Returns the tile id.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * @param tile the tile to be tested
	 * @return the specified tile's id.
	 */
	public static int getId(Tile tile) {
		return tile.getId();
		
	}
	
	/**
	 * @return if the tile is solid (collidable)
	 */
	public boolean getSolid() {
		return this.solid;
	}
	
	/**
	 * @param solid if the tile is solid (collidable)
	 */
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	
	/**
	 * @return the sprite assigned to the current tile
	 */
	public TileSprite getSprite() {
		return this.sprite;
	}
	/**
	 * @param id the id the tile should be set to
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param sprite the Tile sprite image
	 */
	public void setSprite(TileSprite sprite) {
		this.sprite = sprite;
	}
	
	/**
	 * @return the time in millisecounds until the current frame will switch
	 * To be used for debugging
	 */
	public int timeToFrameUpdate() {
		return this.sprite.getAnimationSpeed() - this.elapsedTime;
	}
	
	/**
	 * @return the level color of the current tile
	 */
	public int getLevelColor() {
		return mapColor;
	}
	
	/**
	 * @return the size of the tile (Height = Width)
	 */
	public int getSize() {
		return this.size;
	}
}
