package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise17 {

	public static void main(String[] args) {
		int i, j, n;

		System.out.print("Input number of n : ");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		for (i = 1; i <= n; i++) {
			for (j = 1; j <= i; j++)
				System.out.print(i);
			System.out.println("");
		}
	}
}
