package pathfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Grid {
	
	int sizex = 100, sizey = 100;
	Tile[][] tiles;
	
	public Grid(String dir) throws Exception {
		
		Logger.assertTrue(sizex == sizey, 
				"Grid dimensions are not square, cannot generate grid");
		tiles = new Tile[sizex][sizey];
		
		
		File f = new File(dir);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);					
			
		
		String s = "";			
		int i = 0;
		
		while((s = br.readLine()) != null) {
			
			String[] str = s.split(",");
			for(int j = 0; j < 100; j++) {
				boolean b = (str[j].equals(".")) ? false : true;
				tiles[i][j] = new Tile(i, j, b);					
			}
			i++;
		}
		br.close();		
	}
}