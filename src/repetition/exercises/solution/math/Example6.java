package repetition.exercises.solution.math;

public class Example6 {
	public static void main(String[] args) {
		int num = 1287;
		int isPositive = 1;
		if (num < 0) {
			isPositive = -1;
			num = -1 * num;
		}
		int sum = 0;
		while (num > 0) {
			int r = num % 10;

			int maxDiff = Integer.MAX_VALUE - sum * 10;
			if (sum > Integer.MAX_VALUE / 10 || r > maxDiff)
				System.out.println("Wrong number");
			;

			sum = sum * 10 + r;
			num /= 10;
		}
		System.out.println(isPositive * sum);
	}
}