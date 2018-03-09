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

public class Login {
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
	private static String user = "jonandre@kth.se";
	private static String password = "1234";

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
			String sql = "SELECT * FROM users WHERE mail='" + user + "' AND password='" + password + "'";
			ResultSet res = statement.executeQuery(sql);
			
			/**
			 * Iterate over the result set from the above query
			 */
			while (res.next()) {
				System.out.println("Welcome " + res.getString("firstname") + " " + res.getString("lastname"));
			}
			System.out.println("");
 
			/**
			 * Free all opened resources
			 */
			res.close();
			statement.close(); 
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}