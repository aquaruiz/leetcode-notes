package first_day_challenge.task7;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] result = task7(new int[] {9,9,9,9});
//		System.out.println(result);
		Arrays.stream(result).forEach(System.out::println);

	}

	private static int[] task7(int[] digits) {
		int[] array = digits;
		int lastIndex = array.length - 1;
		if (array[lastIndex] < 9) {
			array[lastIndex]++;
			return array;
		}
		
		while (lastIndex >= 0) {
			if (array[lastIndex] == 9) {
				array[lastIndex--] = 0;
			} else {
				array[lastIndex]++;
				return array;
			}
		}
		
		int[] newArray = new int[array.length+1];
		Arrays.copyOfRange(array, 1, array.length + 1);
		newArray[0] = 1;

		return newArray;
	}

}
