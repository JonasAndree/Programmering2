package repetition.exercises.solution.math;

import java.util.*;

public class Example13 {
	public static void main(String[] args) {

		int decimalNumer, rem, quot, i = 1, j;
		int binNum[] = new int[100];
		Scanner scan = new Scanner(System.in);

		System.out.print("Input a Decimal Number : ");
		decimalNumer = scan.nextInt();

		quot = decimalNumer;

		while (quot != 0) {
			binNum[i++] = quot % 2;
			quot = quot / 2;
		}
		String binaryStr = "";
		System.out.print("Binary number is: ");
		for (j = i - 1; j > 0; j--) {
			binaryStr = binaryStr + binNum[j];
		}
		System.out.print(binaryStr);
		i = binaryStr.length() - 1;
		while (binaryStr.charAt(i) == '0') {
			i--;
		}
		int length = 0;
		int ctr = 0;
		for (; i >= 0; i--) {
			if (binaryStr.charAt(i) == '1') {
				length = Math.max(length, ctr);
				ctr = 0;
			} else {
				ctr++;
			}
		}
		length = Math.max(length, ctr);
		System.out.println("\nLength of the longest sequence: " + length);
	}
}