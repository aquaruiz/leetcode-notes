package first_day_challenge.taskA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
//		int result =
				task2(Arrays.asList(4,4,-2,-1,3));
//		System.out.print(result);
	}

	private static void task2(List<Integer> numbers) {
		
		closestNumbers(numbers);
	}

	private static void closestNumbers(List<Integer> numbers) {
		List<Integer> numsDistinct = numbers.stream().distinct().collect(Collectors.toCollection(ArrayList<Integer>::new));
		Collections.sort(numsDistinct);
		int minDiff = Integer.MAX_VALUE;

		for (int i = 1; i < numsDistinct.size(); i++) {
			int firstNum = numsDistinct.get(i-1);
			int secondNum = numsDistinct.get(i);
			int currentDiff = Math.abs(secondNum - firstNum);
			if (currentDiff < minDiff){
				minDiff = currentDiff;
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int i = 1; i < numsDistinct.size(); i++) {
			int firstNum = numsDistinct.get(i-1);
			int secondNum = numsDistinct.get(i);
			int currentDiff = Math.abs(secondNum - firstNum);
			if (currentDiff == minDiff){
				List<Integer> pair = new ArrayList<>();
				pair.add(firstNum);
				pair.add(secondNum);
				result.add(pair);
			}
		}

		for (List<Integer> resultPair: result) {
			resultPair.forEach(integer -> System.out.printf("%d ", integer));
			System.out.println();
		}
	}
}
