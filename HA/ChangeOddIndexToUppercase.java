package week4.HA;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {

		// Store the output value in a test Variable
		String test = "changeme";

		// Convert the String to a character array
		char[] charArray = test.toCharArray();

		// Iterate through each character of the String (from end to start)
		for (int i = charArray.length - 1; i >= 0; i--) {
			// Check if the index is odd
			if (i % 2 != 0) {
				// Convert the character to uppercase
				charArray[i] = Character.toUpperCase(charArray[i]);
			}
		}

		// Print the modified characters
		System.out.println(charArray);
	}


}



