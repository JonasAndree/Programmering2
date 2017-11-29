package repetition.exercises.solutions.numbers;

import static java.util.stream.LongStream.rangeClosed;

public class Example2 {

	public static void main(String[] args) {
		int countDeficientNo = 0;
		int countPerfectNo = 0;
		int countAbundantNo = 0;

		for (long i = 1; i <= 10_000L; i++) {
			long sum = properDivsSum(i);
			if (sum < i)
				countDeficientNo++;
			else if (sum == i)
				countPerfectNo++;
			else
				countAbundantNo++;
		}
		System.out.println("Number Counting [(integers) between 1 to 10,000]: ");
		System.out.println("Deficient number: " + countDeficientNo);
		System.out.println("Perfect number: " + countPerfectNo);
		System.out.println("Abundant number: " + countAbundantNo);
	}

	public static Long properDivsSum(long num) {
		return rangeClosed(1, (num + 1) / 2).filter(i -> num % i == 0 && num != i).sum();
	}
}