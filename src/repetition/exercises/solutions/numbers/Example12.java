package repetition.exercises.solutions.numbers;

import java.util.Scanner;

public class Example12 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input a number : ");
		int number = scanner.nextInt();
		int x = number, y, sum = 0;

		while (x > 0) {
			y = x % 10;
			sum = sum + y;
			x = x / 10;
		}

		if (number % sum == 0)
			System.out.println(number + " is a Harshad Number.");
		else
			System.out.println(number + " is not a Harshad Number.");
	}
}