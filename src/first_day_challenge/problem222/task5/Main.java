package first_day_challenge.problem222.task5;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		int result = task5(new int[] {12, 2, 1, 1, 12, 2});
		System.out.println(result);
	}

	private static int task5(int[] array) {
		if (array.length == 1) {
			return array[0];
		}
		
		HashMap<Integer, Integer> numbersCount = new HashMap<>();
		
		for (int i = 0; i < array.length; i++) {
			int currentElement = array[i];
			numbersCount.putIfAbsent(currentElement, 0);

			if (numbersCount.get(currentElement) > 1) {
				continue;
			} else {
				numbersCount.put(currentElement, numbersCount.get(currentElement)+1);
			}

		}
		
		for (int key : numbersCount.keySet()) {
			if (numbersCount.get(key) == 1) {
				return key;
			}
		}
		
		return -10;
	}

}
