package repetition.exercises.solutions.array;

import java.util.*;
import java.io.*;

public class Exercise31 {
	public static void main(String[] args) {
		int[] arrayNums = { 10, 77, 10, 54, -11, 10 };
		System.out.println("Original Array: " + Arrays.toString(arrayNums));
		int searchNum = 10;
		int fixedSum = 30;

		System.out.println("Result: " + result(arrayNums, searchNum, fixedSum));
	}

	public static boolean result(int[] numbers, int searchNum, int fixedSum) {
		int tempSum = 0;
		for (int number : numbers) {
			if (number == searchNum) {
				tempSum += searchNum;
			}

			if (tempSum > fixedSum) {
				break;
			}
		}
		return tempSum == fixedSum;
	}
}