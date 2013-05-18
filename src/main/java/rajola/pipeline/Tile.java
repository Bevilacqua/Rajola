package rajola.pipeline;

public abstract class Tile {

	private int id;
	private boolean solid;
	
	public void render() {} 
	
	public abstract void update();
	
	public int getId() {
		return this.id;
	}
	
	public boolean solid() {
		return this.solid;
	}

}
