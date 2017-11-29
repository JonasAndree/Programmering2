package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise23 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the number: ");
		int n = scanner.nextInt();
		for (int i = n; i > 0; i--) {
			for (int spc = n - i; spc > 0; spc--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}