package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input value: ");
		double input = scanner.nextDouble();

		if (input > 0) {
			if (input < 1) {
				System.out.println("Positive small number");
			} else if (input > 1000000) {
				System.out.println("Positive large number");
			} else {
				System.out.println("Positive number");
			}
		} else if (input < 0) {
			if (Math.abs(input) < 1) {
				System.out.println("Negative small number");
			} else if (Math.abs(input) > 1000000) {
				System.out.println("Negative large number");
			} else {
				System.out.println("Negative number");
			}
		} else {
			System.out.println("Zero");
		}
	}
}