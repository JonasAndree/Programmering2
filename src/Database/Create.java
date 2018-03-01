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

public class Create {
	public static void main(String[] args) {

		/**
		 * 3306 is the default port for MySQL in XAMPP. Note both the MySQL server and
		 * Apache must be running.
		 */
		String url = "jdbc:mysql://localhost:3306/";

		/**
		 * The MySQL user.
		 */
		String serverUserName = "Jonas";

		/**
		 * Password for the above MySQL user. If no password has been set (as is the
		 * default for the root user in XAMPP's MySQL), an empty string can be used.
		 */
		String serverPassword = "r32bsW6XvAMhEVrA";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, serverUserName, serverPassword);

			Statement stt = con.createStatement();

			/**
			 * Create and select a database for use.
			 */
			stt.execute("CREATE DATABASE IF NOT EXISTS tek15");
			stt.execute("USE tek15");

			/**
			 * Create an example table
			 */
			stt.execute("DROP TABLE IF EXISTS people");
			stt.execute("CREATE TABLE people (" + "id BIGINT NOT NULL AUTO_INCREMENT," + "firstname VARCHAR(25),"
					+ "lastname VARCHAR(25)," + "PRIMARY KEY(id)" + ")");

			/**
			 * Add entries to the example table
			 */
			stt.execute("INSERT INTO people (firstname, lastname) VALUES"
					+ "('Joe', 'Bloggs'), ('Mary', 'Bloggs'), ('Jill', 'Hill')");

			/**
			 * Query people entries with the lname 'Bloggs'
			 */
			ResultSet res = stt.executeQuery("SELECT * FROM people WHERE lastname = 'Bloggs'");

			/**
			 * Iterate over the result set from the above query
			 */
			while (res.next()) {
				System.out.println(res.getString("firstname") + " " + res.getString("lastname"));
			}
			System.out.println("");

			/**
			 * Same as the last query, but using a prepared statement. Prepared statements
			 * should be used when building query strings from user input as they protect
			 * against SQL injections
			 */
			PreparedStatement prep = con.prepareStatement("SELECT * FROM people WHERE lastname = ?");
			prep.setString(1, "Bloggs");

			res = prep.executeQuery();
			while (res.next()) {
				System.out.println(res.getString("firstname") + " " + res.getString("lastname"));
			}

			/**
			 * Free all opened resources
			 */
			res.close();
			stt.close();
			prep.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}