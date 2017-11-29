package repetition.exercises.solutions.numbers;

import java.util.Scanner;

public class Example3 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the starting number of the range: ");
		int rsnum = scanner.nextInt();
		System.out.print("Input the ending number of the range: ");
		int renum = scanner.nextInt();
		int randomNum = rsnum + (int) (Math.random() * ((renum - rsnum) + 1));
		System.out.println(randomNum);
	}
}