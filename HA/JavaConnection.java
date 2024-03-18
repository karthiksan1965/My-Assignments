package week4.HA;

//Implement the interface in a Concrete class JavaConnection
public class JavaConnection implements DatabseConnection {

	// Concrete implementations for the abstract methods
	public void connect() {
		// Implementation of connect method
		System.out.println("Connected to the database");
	}


	public void disconnect() {
		// Implementation of disconnect method
		System.out.println("Disconnected from the database");
	}


	public void executeUpdate() {
		// Implementation of executeUpdate method
		System.out.println("Executing update on the database");
	}



	public static void main(String[] args) {
		// Create an instance of the concrete class
		JavaConnection connection = new JavaConnection();

		// Call the interface methods
		connection.connect();
		connection.executeUpdate();
		connection.disconnect();
	}




}
