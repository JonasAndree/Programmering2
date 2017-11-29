package repetition.exercises.solutions.methods;

import java.util.Scanner;

public class Exercise14 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the number of sides: ");
		int n = scanner.nextInt();
		System.out.print("Input the side: ");
		double side = scanner.nextDouble();

		System.out.println("The area of the pentagon is " + pentagonArea(n, side));
	}

	public static double pentagonArea(int n, double s) {
		return (n * s * s) / (4 * Math.tan(Math.PI / n));
	}
}
