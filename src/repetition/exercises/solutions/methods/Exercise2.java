package repetition.exercises.solutions.methods;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the first number: ");
		double x = scanner.nextDouble();
		System.out.print("Input the second number: ");
		double y = scanner.nextDouble();
		System.out.print("Input the third number: ");
		double z = scanner.nextDouble();
		System.out.print("The average value is " + average(x, y, z) + "\n");
	}

	public static double average(double x, double y, double z) {
		return (x + y + z) / 3;
	}
}