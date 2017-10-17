package lesson.switchs;

import java.util.ArrayList;

public class MainMazePath {
	
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
	
	private static int height;
	private static int width;
	
	private static ArrayList<ArrayList<Character>> arrayMaze;

	public static void main(String[] args) {
		System.out.println(MAZE);
		parsMaze();
		ArrayList<int[]> path = new ArrayList<>();
		findPath(path, startX, startY);
		drawMaze();
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

		height = arrayMaze.size();
		width = arrayMaze.get(0).size();
	}
	/**
	 * Lets find our way out
	 * @param path
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean findPath(ArrayList<int[]> path, int x, int y) {
		
		// Detects if the path is trying to leave the map.
		if (x < 0 || y < 0 || x >= width || y >= height)
			return false;
		
		// Get this positions cell value
		char cell = arrayMaze.get(y).get(x);
		
		// Detect if it is empty
		if (cell != ' ')
			return false;
		else {
			// if it is not empty add it to our path
			path.add(new int[]{ x, y });
		}
		// Change the cells value so we do not go back to it
		arrayMaze.get(y).set(x, '-');
		
		// If we found our goal we return true
		if (x == endX && y == endY)
			return true;
		
		//go down 
		if (findPath(path, x, y + 1))  return true;
		// go up
		if (findPath(path, x, y - 1))  return true;
		// go left
		if (findPath(path, x + 1, y))  return true;
		// go right
		if (findPath(path, x - 1, y))  return true;
		
		/* if we can't move anywhere we return this path as false and 
		 * we remove the last element in this path.
		 */
		path.remove(path.size() - 1);
		return false;
	}
	
	public static void drawMaze() {
		for(ArrayList<Character> row : arrayMaze) {
			for(char cell : row) {
				if (cell == '#') {
					cell = '\u2588';
				}
				if (cell == '-') {
					cell = ' ';
				}
				System.out.print(cell);
				System.out.print(cell);
			}
			System.out.println();
		}
	}
}























