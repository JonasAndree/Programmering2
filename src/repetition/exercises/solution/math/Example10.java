package repetition.exercises.solution.math;

import java.util.*;

public class Example10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a float number: ");
		float x = scanner.nextFloat();
		System.out.printf("The rounded value of %f is: %.2f", x, roundNum(x));
		System.out.printf("\n");
	}

	public static float roundNum(float fn) {
		float fNum = (float) Math.floor(fn);
		float cNum = (float) Math.ceil(fn);
		if ((fn - fNum) > (cNum - fn)) {
			return cNum;
		} else if ((cNum - fn) > (fn - fNum)) {
			return fNum;
		} else {
			return cNum;
		}
	}

}