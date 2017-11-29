package repetition.exercises.solutions.array;

import java.util.*;
import java.io.*;

public class Exercise32 {
	public static void main(String[] args) {
		int[] arrayNums = { 77, 77, 65, 65, 65, 77 };
		System.out.println("Original Array: " + Arrays.toString(arrayNums));
		int num1 = 77;
		int num2 = 65;

		System.out.println("Result: " + result(arrayNums, num1, num2));
	}

	public static boolean result(int[] arrayNums, int num1, int num2) {
		for (int number : arrayNums) {
			boolean r = number != num1 && number != num2;
			if (r) {
				return false;
			}
		}
		return true;
	}
}