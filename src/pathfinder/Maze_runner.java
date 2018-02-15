package pathfinder;

import java.util.ArrayList;

public class Maze_runner {
	
	/*
	 * TODO : Move all of this shit to a "Teacher" class or something 
	 * This looks bad here
	 * real bad
	 * */
	
	public static ArrayList<Integer>steps = new ArrayList<Integer>();
	public static ArrayList<Integer>dists = new ArrayList<Integer>();
	
	public static void main (String[] args) throws Exception {
		
//		Grid grid = new Grid("Datastore/csvGrid_in_01.csv");
//				
//		Logger.printGrid(grid, 50,50);
//		for(int i = 0; i < 50; i++) {
//		
//			Bot bot = new Bot(50,50,grid, grid.tiles[1][1]);
//			while(!bot.move());
//			//bot.evaluate();			
//		}
//		
		
		
		/*
		 * Bot[] bots = new Bot[10];
		for(int index = 0; index < bots.length; index++) {
			bots[index] = new Bot(75,75,grid, grid.tiles[25][50]);
			bots[index].simulate();
			bots[index].log();
		}
		
		int maxSteps = 0, maxDist = 0;
		for(Integer i : steps) {
			if(i > maxSteps) {
				maxSteps = i;
			}
		}
		for(Integer i : dists) {
			if(i > maxDist) {
				maxDist = i;
			}
		}
		
		try {
		for(Bot _b : bots) {
				
			_b.evaluate(maxDist, maxSteps);			
			
		}
		}catch(Exception e) {e.printStackTrace();}
*/		
	}
}