package lessons.threads.sumthread;

/**
 * This thread finds the sum of a subsection of an array.
 */
public class SumThread extends Thread {
	private int lo, hi;
	private int[] arr;
	private int ans = 0;

	public SumThread(int[] arr, int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
	}

	@Override
	public void run() {
		for (int i = lo; i < hi; i++) {
			ans += arr[i];
		}
	}

	/**
	 * Sum the elements of an array.
	 * 
	 * @param arr
	 *            array to sum
	 * @return sum of the array's elements
	 * @throws InterruptedException
	 *             shouldn't happen
	 */
	public static int sum(int[] arr) throws InterruptedException {
		int len = arr.length;
		int ans = 0;

		// Create and start 4 threads.
		SumThread[] ts = new SumThread[4];
		for (int i = 0; i < 4; i++) {
			ts[i] = new SumThread(arr, (i * len) / 4, ((i + 1) * len / 4));
			ts[i].start();
		}

		// Wait for the threads to finish and sum their results.
		for (int i = 0; i < 4; i++) {
			ts[i].join();
			ans += ts[i].ans;
		}
		return ans;
	}

	public static void main(String[] args) throws InterruptedException {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		int sum = sum(arr);
		System.out.println("Sum: " + sum);
	}
}