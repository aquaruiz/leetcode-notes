package task3;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] result = task3(new int[] {1,2,3,4,5,6,7}, 3);
//		System.out.println(result);
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int[] task3(int[] nums, int k) {
		int arrayLength = nums.length;
		if (k > arrayLength) {
			k = k % arrayLength;
		} 
		
		if (k == arrayLength) {
			return nums;
		}
		
		for (int i = 0; i < k; i++) {
			int lastElement = nums[arrayLength-1];
			for (int j = nums.length-1; j > 0; j--) {
				nums[j] = nums[j-1];
			}

			nums[0] = lastElement;
		}
		
		return nums;
	}

}
