package first_day_challenge.problem222.task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int[] result = task6(new int[] {4,9,5}, new int[] {9,4,9,8,4});
//		System.out.println(result);
		Arrays.stream(result).forEach(System.out::println);

	}

	private static int[] task6(int[] firstArray, int[] secondArray) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(firstArray);
		Arrays.sort(secondArray);
		
		int firstIndex = 0;
		int secondIndex = 0;
		
		while (firstIndex < firstArray.length && secondIndex < secondArray.length) {
			int firstElement = firstArray[firstIndex];
			int secondElement = secondArray[secondIndex];
			
			if (firstElement == secondElement) {
				result.add(firstElement);
				firstIndex++;
				secondIndex++;
			} else if (firstElement < secondElement) {
				firstIndex++;
			} else {
				secondIndex++;
			}
		}

		return result.stream().mapToInt(i->i).toArray();
	
	}

}
