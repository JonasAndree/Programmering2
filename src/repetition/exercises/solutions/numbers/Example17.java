package repetition.exercises.solutions.numbers;

import java.util.Scanner;

public class Example17 {

	public static void main(String args[]) {
		int number;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a number: ");
		number = scanner.nextInt();
		int numOfDigits = 0, divisorPart = 1, circularNumber = number;
		boolean allPrime = true;
		for (int i = number; i > 0; i /= 10) {
			numOfDigits++;
			divisorPart *= 10;
		}
		divisorPart /= 10;
		do {
			circularNumber = circulateFunc(circularNumber, divisorPart);
			if (!isPrime(circularNumber))
				allPrime = false;
		} while (circularNumber != number);
		if (allPrime)
			System.out.println("It is Circular Prime number.");
		else
			System.out.println("It is not a Circular Prime number.");
	}

	public static boolean isPrime(int n) {
		int factorCount = 0;
		if (n < 2)
			return false;
		else if (n == 2)
			return true;
		else if (n % 2 == 0)
			return false;
		else {
			int num = (int) Math.sqrt(n);
			for (int i = 3; i <= num; i += 2) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static int circulateFunc(int n, int divisorPart) {
		if (n < 10)
			return n;
		else
			return (n % divisorPart) * 10 + n / divisorPart;
	}

}