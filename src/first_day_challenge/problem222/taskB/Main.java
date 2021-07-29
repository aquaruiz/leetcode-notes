package first_day_challenge.problem222.taskB;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		task2(Arrays.asList("6 2 2"));
	}

	private static void task2(List<String> numbers) {
		maximumContainers(numbers);
	}

	private static void maximumContainers(List<String> scenarios) {
		for (String scenario : scenarios) {
			List<Integer> input = Arrays.stream(scenario.split(" "))
					.map(Integer::valueOf)
					.collect(Collectors.toList());
			int budget = input.get(0);
			int costPerUnit = input.get(1);
			int freeContToReturn = input.get(2);

			int resultContsMoved = 0;
			int totalContCount = 0;
			int boughtCont = budget / costPerUnit;
			totalContCount += boughtCont;

			resultContsMoved += totalContCount;
			// get free containers
			int gotFreeCont = boughtCont / freeContToReturn;
			totalContCount = boughtCont % freeContToReturn + gotFreeCont;
			resultContsMoved += gotFreeCont;

			if (totalContCount / freeContToReturn >= 1) {
				while (totalContCount / freeContToReturn != 0) {
					gotFreeCont = totalContCount / freeContToReturn;
					totalContCount = totalContCount % freeContToReturn + gotFreeCont;
					resultContsMoved -= totalContCount % freeContToReturn;
					resultContsMoved += gotFreeCont;
				}
			}
			resultContsMoved += totalContCount;

			System.out.println(resultContsMoved);
		}
	}
}
