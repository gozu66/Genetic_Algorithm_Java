package pathfinder;

public class Tile {
	
	int x, y;
	boolean wall;
	
	public Tile(int x, int y, boolean wall) {

		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}