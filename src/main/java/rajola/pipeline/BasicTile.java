package rajola.pipeline;

import rajola.pipeline.sprites.TileSprite;

public class BasicTile extends Tile {

	public BasicTile(int id, TileSprite sprite) {
		super(id, sprite);
	}

	public BasicTile(int id, TileSprite tile, boolean solid) {
		super(id, tile, solid);
	}

}
