package pathfinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Bot {
	
	Grid grid;
	Tile goal;
	public int x, y;		
	int neighborValue = -1;
	
	HashMap<Tile, Boolean> tilesVisited = new HashMap<Tile, Boolean>();
	boolean goalReached;
	int stepsTaken;
	
	HashMap<Integer, Integer> dna = new HashMap<Integer, Integer>();
	int fintness;				//TODO: Mutation et all...
	int mutationRate;	
	
	public Bot(int x, int y, Grid grid, Tile goal)
	{
		this.x = x;
		this.y = y;
		this.grid = grid;
		this.goal = grid.tiles[goal.x][goal.y];
		this.generateDna();
		this.getneighbors();
		this.getNeighborValue();
	}
	
	protected void generateDna() {
		for(int i = 0; i < 255; i++) {
						
			Random rnd = new Random();
			int index = rnd.nextInt(8);			
			dna.put(i, index);
		}
	}
	
	protected ArrayList<Boolean> getneighbors() {

		ArrayList<Boolean> t = new ArrayList<Boolean>();
		
		for(int i = -1; i < 2; i++) {
			
			if(i==0)continue;
			
			if(!(grid.tiles[x][y+i] == null))
				t.add(grid.tiles[x][y+i].wall);	
					else t.add(true);
			
			if(!(grid.tiles[x+i][y+i] == null))
				t.add(grid.tiles[x+i][y+i].wall); 
					else t.add(true);

			if(!(grid.tiles[x+i][y] == null))
				t.add(grid.tiles[x+i][y].wall);	else t.add(true);
			
			if(i==-1) {
				if(!(grid.tiles[x+i][y+1] == null))
					t.add(grid.tiles[x+i][y+1].wall); 
						else t.add(true);
			}
			else {
				if(!(grid.tiles[x+i][y-1] == null))
					t.add(grid.tiles[x+i][y-1].wall); 
						else t.add(true);
			}			
		}
		
		return t;
	}	
	
	protected void getNeighborValue() {
		
		int index = 1;
		int newNeighborValue = 0;
		ArrayList<Boolean> walls = getneighbors();		
		
		for(Boolean b : walls) {		
			if(b) {
				newNeighborValue += index;
			}
			index += index;
		}
		
		if(newNeighborValue == 0) {
			Random rnd = new Random();
			newNeighborValue = rnd.nextInt(7) + 1;
		}
		this.neighborValue = newNeighborValue;
	}
		
	protected boolean move() {

		
		this.stepsTaken++;		
		if(this.stepsTaken > 10000) {
			Logger.println_Formatted("BOT DIED");
			return true;
		}
			
		
		getNeighborValue();
		int dir = dna.get(neighborValue);		
		switch(dir) {

			case 0 : x += 1; y += 1; break;
			case 1 : x -= 1; y -= 1; break;
			case 2 : x += 1; y -= 1; break;
			case 3 : x -= 1; y += 1; break;
			case 4 : y += 1; break;
			case 5 : y -= 1; break;
			case 6 : x += 1; break;
			case 7 : x -= 1; break;
			
		}
		
		if (!(x < grid.tiles.length && y < grid.tiles[0].length && x >= 0 && y >= 0)) {
			
			Logger.println_Formatted("HIT MAP EDGE AT : Grid.Tiles[" + 
						x + "][" + y + "]" + "\nBOT HAD TAKEN   : " + this.stepsTaken + " steps.");						
//			Logger.printGrid(grid, x, y);
			return true;
		}
		
		if(grid.tiles[x][y] == goal) {
			
			this.goalReached = true;
			Logger.println_Formatted("~~~~~~~~ AT FINISH ~~~~~~~~"
						+ "\nBOT HAD TAKEN   : " + this.stepsTaken + " steps.");
			Logger.printGrid(grid, x, y, this.tilesVisited);
			return true;
		}
		
		if (grid.tiles[x][y].wall) {
			
			Logger.println_Formatted("HIT WALL AT     : Grid.Tiles[" + 
						x + "][" + y + "]" + "\nBOT HAD TAKEN   : " + this.stepsTaken + " steps.");
//			Logger.printGrid(grid, x, y, this.tilesVisited);
			return true;
		}
		
		this.tilesVisited.put(grid.tiles[x][y], grid.tiles[x][y].wall);
		return false;
	}

	public void selfEvaluate() {
		
		if (this.goalReached) {
			this.fintness = 1;
		}
		else {
			int xDiff = this.goal.x - this.x;
			int yDiff = this.goal.y - this.y;
			
			int diff = xDiff + yDiff;
			Logger.println_Formatted("DIFF : " + diff);
		}
	}
}