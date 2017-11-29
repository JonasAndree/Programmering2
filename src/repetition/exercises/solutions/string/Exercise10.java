package repetition.exercises.solutions.string;

public class Exercise10 {
	public static void main(String[] args) {

		String string1 = "example.com", str2 = "Example.com";
		StringBuffer strbuf = new StringBuffer(string1);

		System.out.println("Comparing " + string1 + " and " + strbuf + ": " + string1.contentEquals(strbuf));

		System.out.println("Comparing " + str2 + " and " + strbuf + ": " + str2.contentEquals(strbuf));

	}
}
