package repetition.exercises.solutions.numbers;

import java.util.Scanner;

public class Example13 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a number : ");
		int num = scanner.nextInt();
		int ans = 0;

		for (int i = 0; i < num; i++) {
			if (i * (i + 1) == num) {
				ans = 1;
				break;
			}
		}

		if (ans == 1)
			System.out.println("Pronic Number.");
		else
			System.out.println("Not a Pronic Number.");
	}
}