package repetition.exercises.solutions.array;

import java.util.*;
import java.io.*;

public class Exercise30 {
	public static void main(String[] args) {
		int[] arrayNums = { 50, 77, 12, 54, -11 };
		System.out.println("Original Array: " + Arrays.toString(arrayNums));
		System.out.println("Result: " + test(arrayNums));
	}

	public static boolean test(int[] numbers) {
		for (int number : numbers) {
			if (number == 0 || number == -1) {
				return false;
			}
		}
		return true;
	}
}
