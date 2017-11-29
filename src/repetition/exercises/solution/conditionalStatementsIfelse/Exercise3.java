package repetition.exercises.solution.conditionalStatementsIfelse;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input the 1st number: ");
		int number1 = scanner.nextInt();

		System.out.print("Input the 2nd number: ");
		int number2 = scanner.nextInt();

		System.out.print("Input the 3rd number: ");
		int number3 = scanner.nextInt();

		if (number1 > number2)
			if (number1 > number3)
				System.out.println("The greatest: " + number1);

		if (number2 > number1)
			if (number2 > number3)
				System.out.println("The greatest: " + number2);

		if (number3 > number1)
			if (number3 > number2)
				System.out.println("The greatest: " + number3);
	}
}