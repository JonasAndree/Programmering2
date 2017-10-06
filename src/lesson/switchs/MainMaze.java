package lesson.switchs;

import java.util.ArrayList;

public class MainMaze {
	
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
		System.out.println(MAZE);
		parsMaze();
	}
	
	public static void parsMaze() {
		int x = 0;
		int y = 0;
		ArrayList<Character> row = new ArrayList<>();
		arrayMaze = new ArrayList<>();
		for (char cell : MAZE.toCharArray() ) {
			switch (cell) {
			case '#':
				row.add(cell);
				x++;
			case ' ':
				row.add(cell);
				x++;
			case '\n':
				arrayMaze.add(row);
				row = new ArrayList<>();
				y++;
				x = 0;
			}
		}
	}
}
