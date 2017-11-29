package repetition.exercises.solutions.string;

public class Exercise21 {
	public static void main(String[] args) {
		String text = "The quick brown fox jumps over the lazy dog.";

		// Get the index of all the characters of the alphabet
		// starting from the beginning of the String.
		int a = text.lastIndexOf("a", text.length() - 1);
		int b = text.lastIndexOf("b", text.length() - 1);
		int c = text.lastIndexOf("c", text.length() - 1);
		int d = text.lastIndexOf("d", text.length() - 1);
		int e = text.lastIndexOf("e", text.length() - 1);
		int f = text.lastIndexOf("f", text.length() - 1);
		int g = text.lastIndexOf("g", text.length() - 1);
		int h = text.lastIndexOf("h", text.length() - 1);
		int i = text.lastIndexOf("i", text.length() - 1);
		int j = text.lastIndexOf("j", text.length() - 1);
		int k = text.lastIndexOf("k", text.length() - 1);
		int l = text.lastIndexOf("l", text.length() - 1);
		int m = text.lastIndexOf("m", text.length() - 1);
		int n = text.lastIndexOf("n", text.length() - 1);
		int o = text.lastIndexOf("o", text.length() - 1);
		int p = text.lastIndexOf("p", text.length() - 1);
		int q = text.lastIndexOf("q", text.length() - 1);
		int r = text.lastIndexOf("r", text.length() - 1);
		int s = text.lastIndexOf("s", text.length() - 1);
		int t = text.lastIndexOf("t", text.length() - 1);
		int u = text.lastIndexOf("u", text.length() - 1);
		int v = text.lastIndexOf("v", text.length() - 1);
		int w = text.lastIndexOf("w", text.length() - 1);
		int x = text.lastIndexOf("x", text.length() - 1);
		int y = text.lastIndexOf("y", text.length() - 1);
		int z = text.lastIndexOf("z", text.length() - 1);

		// Display the results of all the lastIndexOf method calls.
		System.out.println(" a  b c  d  e  f  g  h i  j");
		System.out.println("===========================");
		System.out.println( a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + "\n");

		System.out.println("k  l  m  n  o  p q  r  s  t");
		System.out.println("===========================");
		System.out.println( k + " " + l + " " + m + " " + n + " " + o + " " + p + " " + q + " " + r + " " + s + " " + t + "\n");

		System.out.println(" u  v  w  x  y  z");
		System.out.println("=================");
		System.out.println(u + " " + v + " " + w + " " + x + " " + y + " " + z);
	}
}