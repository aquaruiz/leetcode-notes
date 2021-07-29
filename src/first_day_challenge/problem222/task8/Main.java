package first_day_challenge.problem222.task8;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] result = task8(new int[] {6,0,0,0,0,0,1,0,3,12});
//		System.out.println(result);
		Arrays.stream(result).forEach(System.out::println);

	}

	private static int[] task8(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		
		int lastSlot = 0;
		
		for (int i = 0; i < nums.length; i++) {
			int currentElement = nums[i]; 
			if (currentElement != 0) {
				nums[lastSlot++] = currentElement;
			}
		}
		
		for (int i = lastSlot; i < nums.length; i++) {
			nums[i] = 0;
		}
		return nums;
	}

}
