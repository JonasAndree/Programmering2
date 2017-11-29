package repetition.exercises.solutions.numbers;

import java.util.Scanner;

public class Example18 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a number: ");
		int num = scanner.nextInt();
		int n = (int) Math.round(Math.pow(num, 1.0 / 3.0));
		if ((num == n * n * n)) {
			System.out.print("Number is a cube.");
		} else {
			System.out.print("Number is not a cube.");
		}
		System.out.println("\n");
	}
}