package pathfinder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public abstract class Logger {
	
	public static <T> void assertTrue(Boolean assertion, T message) {
		
		if(assertion) return;
		
		throw new Error(
				  "\n\n"	
				+ "**********!! Assertion Failed !!***********\n"
				+ message + "\n" 
				+ "*******************************************\n"
		);
	}
	
	public static <T> void softAssertTrue(Boolean assertion, T message) {
		
		if(assertion) return;
		
		System.err.println(
				  "\n\n"	
				+ "**********!! Assertion Failed !!***********\n"
				+ message + "\n" 
				+ "*******************************************\n"
		);
	}
	
	public static <T> void println_Formatted(T message) {
		
		System.out.println(
				  "\n"	
				+ "——————————————————————————————————————————\n"
				+ message + "\n" 
				+ "__________________________________________\n"
		);
	}
	
	public static <T> void println_list(T message)
	{
		System.out.print(
				" --> " + message + ","
			);
	}

	public static void printGrid(Grid grid) {
		
		for(int x = 0; x < grid.sizex; x++) {
			for(int y = 0; y < grid.sizey; y++) {
				
				String s = (grid.tiles[x][y].wall) ? "@" : ".";			
				System.out.print(s);
			}
			System.out.print("\n");			
		}
	}
	
	public static void printGrid(Grid grid, int botx, int boty) {
		
		for(int x = 0; x < grid.sizex; x++) {
			for(int y = 0; y < grid.sizey; y++) {
				
				if(x == botx && y == boty) {
					System.out.print("^");
					continue;
				}
					
				String s = (grid.tiles[x][y].wall) ? "@" : ".";			
				System.out.print(s);
			}
			System.out.print("\n");			
		}
	}

	public static void printGrid(Grid grid, int botx, int boty, HashMap<Tile, Boolean> map) {
		
		for(int x = 0; x < grid.sizex; x++) {
			for(int y = 0; y < grid.sizey; y++) {
				
				if(x == botx && y == boty) {
					System.out.print("^");
					continue;
				}
				
				boolean walked = false;
				for(Tile t : map.keySet()) {
					if (t.equals(grid.tiles[x][y])) {
						walked = true;
						System.out.print("=");
						break;
					}
				}				
				if(walked)	continue;
				
				String s = (grid.tiles[x][y].wall) ? "@" : ".";			
				System.out.print(s);
			}
			System.out.print("\n");			
		}
	}
	
	public static void printGridToCSV(Grid grid) throws IOException {
							
		File f = new File("Datastore/csvGrid_out_.csv");
		FileWriter csvGrid = new FileWriter(f);
		PrintWriter pw = new PrintWriter(csvGrid);										
	
		String s = "";
		for(int x = 0; x < grid.sizex; x++) {
			for(int y = 0; y < grid.sizey; y++) {
									
				s += (grid.tiles[x][y].wall) ? "@," : " ,";
			}
			pw.println(s);
			s = "";
		}				
		pw.close();
	}	
	
}