package repetition.exercises.solution.math;

import java.util.*;

public class Example2 {
	public static void main(String[] args) {
		double value = 12.56;
		double fractionalPart = value % 1;
		double integralPart = value - fractionalPart;
		System.out.print("\nOriginal value: " + value);
		System.out.print("\nIntegral part: " + integralPart);
		System.out.print("\nFractional part: " + fractionalPart);
		System.out.println();
	}
}