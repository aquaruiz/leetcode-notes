package first_day_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		/**
		 int x (zero change times), array integers (0 or 1),
		 start index, end index of ones sequence
		 */
//		Scanner scanner = new Scanner(System.in);
//		int count = Integer.parseInt(scanner.nextLine());
//		List<Integer> inputArray = Arrays.stream(scanner.nextLine()
//				.split(" "))
//				.map(Integer::valueOf)
//				.collect(Collectors.toList());

		int count = 1;
		List<Integer> inputArray = new ArrayList<>();
		inputArray.add(0);
		inputArray.add(1);
		inputArray.add(0);
		inputArray.add(0);
		inputArray.add(1);
		inputArray.add(0);
		int longestOnesSequence = longestOnesSequence(count, inputArray);

		System.out.println(longestOnesSequence);
	}

	private static int longestOnesSequence(int count, List<Integer> arr) {
		int longestOnesSequence = 0;
		if (count == 0) {
			return longestOnesSequence;
		}

		for (int i = 0; i < arr.size(); i++) {
			int currentElement = arr.get(i);
			longestOnesSequence++;
			if (currentElement == 0) {
				count--;
				if (count == 0 && i != arr.size()-1) {
					count++;
					longestOnesSequence--;
				}
			}
		}

		return longestOnesSequence;
	}
}
