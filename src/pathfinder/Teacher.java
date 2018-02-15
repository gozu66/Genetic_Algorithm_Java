package pathfinder;

public class Teacher {
	
	Bot[] stagingPool;
	public Teacher(int numBots, int startx, int starty, Tile goal, Grid grid) {
		
		this.stagingPool = new Bot[numBots];
		for(Bot bot : this.stagingPool) {
			bot = new Bot(startx, starty, grid, goal);
		}
		
		
	}
}
