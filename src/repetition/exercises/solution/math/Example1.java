package repetition.exercises.solution.math;

import java.util.*;

public class Example1 {
	public static void main(String[] args) {
		int totTheoryMarks = 350, totPracticalMarks = 90, totMarks = 500;
		int percentageOfMarks = ((totTheoryMarks + totPracticalMarks) * 100) / totMarks;
		System.out.print("\nPercentage of Marks: " + percentageOfMarks + "%\n");
	}
}