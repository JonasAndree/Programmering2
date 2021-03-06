package lesson.generics;

import java.util.ArrayList;

public class Maze {
	
	private final static String MAZE =
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

	private static ArrayList<ArrayList<Character>> arrayMaze;
	
	public static void main(String[] args) {
		parseMaze();
		drawMaze();
	}
	private static void parseMaze() {
		ArrayList<Character> row = new ArrayList<>();
		int x = 0, y = 0;
		arrayMaze = new ArrayList<>();
		
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
				arrayMaze.add(row);
				row = new ArrayList<>();
				break;
			}
			if (cell != '\n')
				x += 1;
		}

	}

	static void drawMaze() {
		for (ArrayList<Character> row : arrayMaze) {
			for (char cell : row) {
				if (cell == '#')
					cell = '\u2588';
				System.out.print(cell);
				System.out.print(cell);
			}
			System.out.println();
		}
	}

}
