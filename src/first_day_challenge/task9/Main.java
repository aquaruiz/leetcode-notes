package first_day_challenge.task9;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] result = task(new int[] {-1,-2,-3,-4,-5}, -8);
//		System.out.println(result);
		Arrays.stream(result).forEach(System.out::println);

	}

	private static int[] task(int[] nums, int target) {
		int[] result = new int[2];
		
		for (int i = 0; i < nums.length; i++) {
			int currentNumber = nums[i];

			for (int j = i+1; j < nums.length; j++) {
				if (currentNumber + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		return result;
	}

}
