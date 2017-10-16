package lesson.switchs;

import java.util.ArrayList;

public class MainMaze {
	
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
	}
	
	public static void drawMaze() {
		for(ArrayList<Character> row : arrayMaze) {
			for(char cell : row) {
				if (cell == '#') {
					cell = '\u2588';
				}
				System.out.print(cell);
				System.out.print(cell);
			}
			System.out.println();
		}
	}
}























