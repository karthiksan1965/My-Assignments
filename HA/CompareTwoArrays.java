package week4.HA;

public class CompareTwoArrays {
	public static void main(String[] args) {
		//Array1 Elements
		int[] array1 = {3, 2, 11, 4, 6, 7};
		//Array2 Elements
		int[] array2 = {1, 2, 8, 4, 9, 7};

		// Iterate through the first array
		for (int i = 0; i < array1.length; i++) {
			// Use a nested for loop to Iterate through the second array
			for (int j = 0; j < array2.length; j++) {
				// Compare elements of both arrays
				if (array1[i] == array2[j]) {
					// Print the matching element
					System.out.println("Matching element: " + array1[i]);
				}
			}
		}
	}
}


