package repetition.exercises.solutions.methods;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the first number: ");
		double x = scanner.nextDouble();
		System.out.print("Input the Second number: ");
		double y = scanner.nextDouble();
		System.out.print("Input the third number: ");
		double z = scanner.nextDouble();
		System.out.print("The smallest value is " + smallest(x, y, z) + "\n");
	}

	public static double smallest(double x, double y, double z) {
		return Math.min(Math.min(x, y), z);
	}
}
