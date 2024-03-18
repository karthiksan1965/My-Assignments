package week4.HA;

public class JavaConnectionLatest extends MySqlConnection {

	public static void main(String[] args) {


		// Create an instance of JavaConnection
		JavaConnectionLatest connection = new JavaConnectionLatest();

		// Call methods to demonstrate functionality
		connection.connect();
		connection.executeQuery();
		connection.executeUpdate();
		connection.disconnect();
	}
}