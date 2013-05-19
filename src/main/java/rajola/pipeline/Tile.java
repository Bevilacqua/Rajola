package rajola.pipeline;

import rajola.pipeline.sprites.TileSprite;

public abstract class Tile {

	private int id;
	private boolean solid;
	private TileSprite sprite;
	private int elapsedTime;
	
	public Tile(int id ,TileSprite sprite) {
		this.id = id;
		this.solid = false;
		this.sprite = sprite;
	}
	
	public Tile(int id ,TileSprite sprite , boolean solid) {
		this.id = id;
		this.sprite = sprite;
		this.solid = solid;
	}
	
	/**
	 * @param x the location to draw the tile
	 * @param y the location to draw the tile
	 * To be used in debugging
	 */
	public void render(int x , int y) {
		sprite.render(x, y);
	} 
	
	public void update(int d) {		
		if(elapsedTime < this.sprite.getAnimationSpeed()) {
			elapsedTime += d;
		} else {
			if(this.sprite.getCurrentFrame() < this.sprite.getFrames().size() - 1) this.sprite.incrementFrame();
			else this.sprite.setCurrentFrame(0);
			elapsedTime = 0;
		}
	}
	
	/**
	 * @return the tiles id;
	 */
	public int getId() {
		return this.id;
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

}
