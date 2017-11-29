package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise31 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input first number: ");
		double x = scanner.nextDouble();
		System.out.print("Input second number: ");
		double y = scanner.nextDouble();
		System.out.print("Input third number: ");
		double z = scanner.nextDouble();
		if (x < y && y < z) {
			System.out.println("Increasing order");
		} else if (x > y && y > z) {
			System.out.println("Decreasing order");
		} else {
			System.out.println("Neither increasing or decreasing order");
		}
	}
}