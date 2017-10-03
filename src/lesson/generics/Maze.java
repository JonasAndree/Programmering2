package lesson.generics;

import java.util.ArrayList;

public class Maze {
	
	private static String MAZE =
			"#######################\n" +
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
			"  # #         #     # #\n" +
			"### # ####### ####### #\n" +
			"#   # #     #         #\n" +
			"# ### ##### ###########\n" +
			"#                     #\n" +
			"#######################\n";

	private static ArrayList<ArrayList<Character>> maze;
	
	
	
	private static int width, height;
	
	public static void main(String[] args) {
		parseMaze();
		drawMaze();
	}
	private static void parseMaze() {
		ArrayList<Character> row = new ArrayList<>();
		
		int x = 0, y = 0;
		maze = new ArrayList<>();
		
		for (char cell : MAZE.toCharArray()) {
			switch (cell) {
			case '#':
				row.add('#');
				break;
			case ' ':
				row.add(' ');
				break;
			case '\n':
				y += 1;
				x = 0;
				maze.add(row);
				row = new ArrayList<>();
				break;
			}
			if (cell != '\n')
				x += 1;
		}

		height = maze.size();
		width = maze.get(0).size();
	}

	static void drawMaze() {
		for (ArrayList<Character> row : maze) {
			for (char cell : row) {
				if (cell == '#')
					cell = '\u2588';
				System.out.print(cell);
				System.out.print(cell == '/' ? '\\' : cell == '\\' ? '/' : cell);
			}
			System.out.println();
		}
	}

}
