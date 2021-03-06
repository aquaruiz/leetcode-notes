package first_day_challenge.taskC;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("24 24");
		List<Integer> result = getMinimumUniqueSum(input);
		result.forEach(System.out::println);
//		System.out.print(result);
	}

	private static List<Integer> getMinimumUniqueSum(List<String> arr) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < arr.size(); i++) {
			List<Integer> input = Arrays.stream(arr.get(i).split(" "))
					.map(Integer::valueOf)
					.collect(Collectors.toList());

			int start = input.get(0);
			int end = input.get(1);
			int count = 0;

			for (int j = start; j <= end; j++) {
				double sqr = Math.sqrt(j);
				if (sqr == (int)(sqr)){
					count++;
					j = (int)(Math.pow(sqr+1 ,2)-1);
				}
			}

			result.add(count);
		}

		return result;
	}

}
