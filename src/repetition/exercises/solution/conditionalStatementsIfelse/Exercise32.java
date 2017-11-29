package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise32 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input first floating­point number: ");
		double number1 = input.nextDouble();
		System.out.print("Input second floating­point number: ");
		double number2 = input.nextDouble();
		input.close();

		if (Math.abs(number1 - number2) <= 0.01) {
			System.out.println("These numbers are the same.");
		} else {
			System.out.println("These numbers are different.");
		}
	}
}