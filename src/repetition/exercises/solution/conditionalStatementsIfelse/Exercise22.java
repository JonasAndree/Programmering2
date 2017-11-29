package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise22 {

	public static void main(String[] args) {
		int noRow, c = 1, blk, i, j;
		System.out.print("Input number of rows: ");
		Scanner scanner = new Scanner(System.in);
		noRow = scanner.nextInt();
		for (i = 0; i < noRow; i++) {
			for (blk = 1; blk <= noRow - i; blk++)
				System.out.print(" ");
			for (j = 0; j <= i; j++) {
				if (j == 0 || i == 0)
					c = 1;
				else
					c = c * (i - j + 1) / j;
				System.out.print(" " + c);
			}
			System.out.print("\n");
		}
	}
}