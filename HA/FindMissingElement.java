package week4.HA;

import java.util.Arrays;

public class FindMissingElement {
	public static void main(String[] args) {
		int[] array = {1, 4, 3, 2, 8, 6, 7};

		// Sort the array
		Arrays.sort(array);

		// Loop through the array
		for (int i = 0; i < array.length; i++) {
			// Check if iterator variable is not equal to the array values respectively
			if (i + 1 != array[i]) {
				// Print the missing number
				System.out.println("Missing Number: " + (i + 1));
				// Break the iteration once missing number is found
				break;
			}
		}
	}
}
