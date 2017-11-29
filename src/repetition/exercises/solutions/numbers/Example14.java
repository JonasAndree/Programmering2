package repetition.exercises.solutions.numbers;

import java.util.Scanner;

public class Example14 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a number : ");
		int num = scanner.nextInt();
		int sqNum = num * num;

		String strNumber = Integer.toString(num);
		String square = Integer.toString(sqNum);

		if (square.endsWith(strNumber))
			System.out.println("Automorphic Number.");
		else
			System.out.println("Not an Automorphic Number.");
	}
}