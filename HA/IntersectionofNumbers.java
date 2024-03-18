package week4.HA;

import java.util.ArrayList;
import java.util.List;

public class IntersectionofNumbers {
	public static void main(String[] args) {
		//Array1 Elements
		int[] array1 = {3, 2, 11, 4, 6, 7};
		//Array2 Elements
		int[] array2 = {1, 2, 8, 4, 9, 7};

		// Convert arrays to lists
		List<Integer> list1 = new ArrayList<Integer>();
		for (int num : array1) {
			list1.add(num);
		}

		List<Integer> list2 = new ArrayList<Integer>();
		for (int num : array2) {
			list2.add(num);
		}

		// Iterate through list1 and check for intersection with list2
		System.out.println("Intersection of numbers:");
		for (int num : list1) {
			if (list2.contains(num)) {
				System.out.println(num);
			}
		}
	}
}


