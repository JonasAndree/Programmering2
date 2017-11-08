package lesson.switchs;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class MainMaze  {
	
	private final static String MAZE =
			"#############G#########\n" +
			"# #       # #         #\n" +
			"# # # ### # # ####### #\n" +
			"#   #   #   # #   #   #\n" +
			"# ##### ##### # # # ###\n" +
			"#     #     # # # # # #\n" +
			"# ######### ### # # # #\n" +
			"# #     #   #   #   # #\n" +
			"# # ### # # # ####### #\n" +
			"# # #     # #   #     #\n" +
			"# # ########### ### # #\n" +
			"S # #         #     # #\n" +
			"### # ####### ####### #\n" +
			"#   # #     #         #\n" +
			"# ### ##### ###########\n" +
			"#                     #\n" +
			"#######################\n";
	private static int startX;
	private static int startY;
	
	private static int endX;
	private static int endY;
	
	private static ArrayList<ArrayList<Character>> arrayMaze;

	public static void main(String[] args) {
		System.out.println(MAZE);
		parsMaze();
		
		ArrayList<int[]> path = new ArrayList<>();
		
		findPath(path, startX, startY, endX, endY);
		drawMaze(path);
	}
	
	public static void parsMaze() {
		int x = 0;
		int y = 0;
		ArrayList<Character> row = new ArrayList<>();
		arrayMaze = new ArrayList<>();
		for (char cell : MAZE.toCharArray() ) {
			switch (cell) {
			case '#':  row.add(cell);
					   x++;
					   break;
			case ' ':  row.add(cell);
					   x++;
					   break;
			case 'S':  row.add(' ');
					   startX = x;
					   startY = y;
					   x++;
					   break;
			case 'G':  row.add(' ');
					   endX = x;
					   endY = y;
					   x++;
					   break;
			case '\n': arrayMaze.add(row);
					   row = new ArrayList<>();
					   y++;
					   x = 0;
					   break;
			}
		}
	}
	
	public static boolean findPath(ArrayList<int[]> path, int x, int y, int gX, int gY) {
		
		/*
		  drawMaze(path);
		 
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		if (x < 0 || y < 0 || x > arrayMaze.get(0).size() || y > arrayMaze.size()) {
			return false;
		}
		
		char cell = arrayMaze.get(y).get(x);
		
		if (cell == '#' || cell == '-')
			return false;
		
		path.add(new int[] {x, y});
		arrayMaze.get(y).set(x, '-');
		
		if (x == gX && y == gY) {
			return true;
		}
		
		if (findPath(path, x, y + 1, gX, gY))
			return true;
		if (findPath(path, x, y - 1, gX, gY))
			return true;
		if (findPath(path, x + 1, y, gX, gY))
			return true;
		if (findPath(path, x - 1, y, gX, gY))
			return true;
		
		path.remove(path.size() - 1);
		return false;
	}
	
	
	public static void drawMaze(ArrayList<int[]> path) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		int[] position = path.get(0);
		int currentX = position[0];
		int currentY = position[1];
		path.remove(0);
		int y = 0;
		int x = 0;
		System.out.println("currentX= " + currentX + ", currentY= " + currentY);
		for(ArrayList<Character> row : arrayMaze) {
			for(char cell : row) {
				if (cell == '#') {
					cell = '\u2588';
				}
				if (cell == '-') {
					cell = ' ';
				}
				
				if (currentX == x && currentY == y) {
					cell = '\u2526';
					System.out.print(cell);
					cell = '\u2524';
					System.out.print(cell);
				} else {
					System.out.print(cell);
					System.out.print(cell);
				}
					
				x++;
			}
			System.out.println();
			x = 0;
			y++;
		}

		if (path.size() != 0) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			drawMaze(path);
		}
	}

}























