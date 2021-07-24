package task15;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		boolean result = task("anagram", "nagaram");
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static boolean task(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		Map<Character, Integer> letters = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			letters.putIfAbsent(currentChar, 0);
			letters.put(currentChar, letters.get(currentChar)+1);
		}
		
		for (int j = 0; j < t.length(); j++) {
			char currentChar = t.charAt(j);
			if (!letters.containsKey(currentChar)
					|| letters.get(currentChar) == 0) {
				return false;
			}
			
			letters.put(currentChar, letters.get(currentChar)-1);
		}
		
		for (Integer value : letters.values()) {
			if (value != 0) {
				return false;
			}
		}
		return true;
	}
}
