package task14;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		int result = task("aabb");
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static int task(String s) {
		Map<Character, Integer> lettersCount = new LinkedHashMap<>();
		Map<Character, Integer> lettersIndeces = new LinkedHashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			lettersCount.putIfAbsent(currentChar, 0);
			lettersCount.put(currentChar, lettersCount.get(currentChar)+1);
			lettersIndeces.put(currentChar, i);
		}
		
		for (Character key : lettersCount.keySet()) {
			if (lettersCount.get(key)==1) {
				return lettersIndeces.get(key);
			}
		}
		return -1;
	}

}
