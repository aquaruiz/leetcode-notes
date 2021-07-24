package task4;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		boolean result = task4(new int[] {1,2,3,1});
		System.out.println(result);
	}

	private static boolean task4(int[] array) {
		HashMap<Integer, Integer> numbersCount = new HashMap<>();
		
		for (int i = 0; i < array.length; i++) {
			int currentElement = array[i];
			numbersCount.putIfAbsent(currentElement, 0);
			numbersCount.put(currentElement, numbersCount.get(currentElement)+1);
		}
		
		for (int count : numbersCount.values()) {
			if (count > 1) {
				return true;
			}
		}
		
		return false;
	}

}
