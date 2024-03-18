package week4.HA;



public abstract class MySqlConnection implements DatabseConnection {

	// Concrete implementations for the abstract methods
	public void connect() {
		// Implementation of connect method
		System.out.println("Connected to the MySQL database");
	}


	public void disconnect() {
		// Implementation of disconnect method
		System.out.println("Disconnected from the MySQL database");
	}


	public void executeUpdate() {
		// Implementation of executeUpdate method
		System.out.println("Executing update on the MySQL database");
	}

	// Implementation of executeQuery method

	public void executeQuery() {
		// Implementation details for executing query in JavaConnection
		System.out.println("Executing query in MySQL database");
	}


}


