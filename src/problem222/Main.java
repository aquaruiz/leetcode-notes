package problem222;

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
		Scanner scanner = new Scanner(System.in);
		int count = Integer.parseInt(scanner.nextLine());
		List<Integer> inputArray = Arrays.stream(scanner.nextLine()
				.split(" "))
				.map(Integer::valueOf)
				.collect(Collectors.toList());

//		int count = 3;
//		List<Integer> inputArray = List.of(0,1,0,0,1,1,0,1);
		int longestOnesSequence = 0;

		for (int i = 0; i < inputArray.size(); i++) {
			longestOnesSequence++;
			if (inputArray.get(i) == 0) {
				count--;
				if (count == 0 && i != inputArray.size()-1) {
					count++;
					longestOnesSequence--;
				}
			}
		}

		System.out.println(longestOnesSequence);
	}

}
