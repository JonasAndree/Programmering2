package repetition.exercises.solution.math;

import java.lang.*;
import java.math.BigDecimal;

public class Example4 {
	public static void main(String[] args) {
		float x = 451.3256412f;
		BigDecimal result;
		int decimalPlace = 4;
		BigDecimal bdNum = new BigDecimal(Float.toString(x));
		bdNum = bdNum.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		System.out.printf("Original number: %.7f\n", x);
		System.out.println("Rounded upto 4 decimal: " + bdNum);
	}
}