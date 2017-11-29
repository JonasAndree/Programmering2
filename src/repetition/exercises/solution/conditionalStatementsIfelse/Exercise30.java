package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise30 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input first number: ");
		int x = scanner.nextInt();
		System.out.print("Input second number: ");
		int y = scanner.nextInt();
		System.out.print("Input third number: ");
		int z = scanner.nextInt();

		if (x == y && x == z) {
			System.out.println("All numbers are equal");
		} else if ((x == y) || (x == z) || (z == y)) {
			System.out.println("Neither all are equal or different");
		} else {
			System.out.println("All numbers are different");
		}
	}
}