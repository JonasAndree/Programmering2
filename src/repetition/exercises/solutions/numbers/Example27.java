package repetition.exercises.solutions.numbers;

import java.util.Scanner;

public class Example27 {

	public static void main(String args[]) {
		int num;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a number: ");
		num = scanner.nextInt();
		int numOffDigits = 0, divisorPart = 1, circularNumber = num;
		boolean allPrime = true;
		for (int temp = num; temp > 0; temp /= 10) {
			numOffDigits++;
			divisorPart *= 10;
		}
		divisorPart /= 10;
		System.out.println("Output: ");
		do {
			System.out.println("        " + circularNumber);
			circularNumber = circulate(circularNumber, divisorPart);
			if (!isPrime(circularNumber))
				allPrime = false;
		} while (circularNumber != num);
		System.out.print("\n        ");
		if (allPrime)
			System.out.println(num + " is a circular_num Prime number.");
		else
			System.out.println(num + " It is not a Circular Prime number.");
	}

	public static boolean isPrime(int number) {
		int factorCount = 0;
		if (number < 2)
			return false;
		else if (number == 2)
			return true;
		else if (number % 2 == 0)
			return false;
		else {
			int limit = (int) Math.sqrt(number);
			for (int i = 3; i <= limit; i += 2) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static int circulate(int n, int divisorPart) {
		if (n < 10)
			return n;
		else
			return (n % divisorPart) * 10 + n / divisorPart;
	}

}