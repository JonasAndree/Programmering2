package Database;

/**
 * Imports all entries from the java.sql library. 
 * Improve on this by only importing needed classes. 
 * E.g.:
 * import java.sql.Connection
 * import java.sql.Statement
 * ...
 */
import java.sql.*;

public class Register {
	/**
	 * 3306 is the default port for MySQL in XAMPP. Note both the MySQL server and
	 * Apache must be running.
	 */
	private static String url = "jdbc:mysql://localhost:3306/";
	/**
	 * The server side MySQL user.
	 */
	private static String serverUserName = "root";
	/**
	 * Password for the above MySQL user. If no password has been set (as is the
	 * default for the root user in XAMPP's MySQL), an empty string can be used.
	 */
	private static String serverPassword = "";
	// Sould be enterd by the user of the program.
	private static String mail = "jonandreTe@kth.se";
	private static String password = "1234";
	private static String lastName = "test";
	private static String firstName = "lastTest";
	private static String birthdate = "1234-12-12";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, serverUserName, serverPassword);
			Statement statement = con.createStatement();
			/**
			 * Create and select a database for use.
			 */
			statement.execute("USE tek15");

			/**
			 * Query people entries with the selected username and password.
			 */
			String sql = "INSERT INTO `users` (`firstname`, `lastname`, `mail`, `password`, `birthdate`) " + "VALUES('"
					+ firstName + "', '" + lastName + "','" + mail + "','" + password + "','" + birthdate + "')";

			statement.execute(sql);

			/**
			 * Free all opened resources
			 */
			statement.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registration successfull!");
	}
}