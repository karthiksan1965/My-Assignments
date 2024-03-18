package week4.HA;

import java.util.Arrays;

public class SecondLargestNumber {



	public static void main(String[] args) {
		//Array Elements
		int[] array = {3, 2, 11, 4, 6, 7};

		// Sort the array in ascending order
		Arrays.sort(array);

		// Print the second largest number
		if (array.length >= 2) 
		{
			System.out.println("Second largest number: " + array[array.length - 2]);

		} else 

		{

			System.out.println("Array doesn't have enough elements.");
		}
	}
}


