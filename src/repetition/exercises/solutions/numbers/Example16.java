package repetition.exercises.solutions.numbers;

import java.util.Scanner;

public class Example16 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the first number: ");
		int num1 = scanner.nextInt();
		System.out.print("Input the second number: ");
		int num2 = scanner.nextInt();
		int sumNum1 = 0, sumNum2 = 0;
		for (int i = 1; i <= num1; i++) {
			if (num1 % i == 0)
				sumNum1 += i;
		}
		for (int i = 1; i <= num2; i++) {
			if (num2 % i == 0)
				sumNum2 += i;
		}
		if (sumNum1 == sumNum2)
			System.out.println("These numbers are amicable.");
		else
			System.out.println("These numbers are not amicable.");
		System.out.println("\n");
	}
}