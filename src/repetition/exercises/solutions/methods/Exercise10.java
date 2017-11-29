package repetition.exercises.solutions.methods;

import java.util.Scanner;

public class Exercise10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a year: ");
		int year = scanner.nextInt();

		System.out.println(isLeapYear(year));
	}

	public static boolean isLeapYear(int y) {
		boolean a = (y % 4) == 0;
		boolean b = (y % 100) != 0;
		boolean c = ((y % 100 == 0) && (y % 400 == 0));

		return a && (b || c);
	}
}
