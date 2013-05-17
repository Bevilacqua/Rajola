package rajola.pipeline;

public abstract class Tile {

	private int id;
	
	public void render() {} 
	
	public abstract void update();
	
	public int getId() {
		return this.id;
	}

}
