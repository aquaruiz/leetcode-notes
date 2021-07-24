package task20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String result = task(new String [] {"ab","a"});
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static String task(String[] strs) {
		if (strs.length == 1) {
			return strs[0];
		}
		Arrays.sort(strs, (a, b) -> a.length() - b.length());
		
		int shortestLength = strs[0].length();
		if (shortestLength == 0) {
			return "";
		}
		
		List<Character> letters = new ArrayList<>();
		letters.add(strs[0].charAt(0));
		for (String string : strs) {
			if (letters.get(0) != string.charAt(0)) {
				return "";
			}
		}
		
		for (int i = 1; i < shortestLength; i++) {
			letters.add(strs[0].charAt(i));
			for (String string : strs) {
				if (letters.get(i) != string.charAt(i)) {
					letters.remove(i);
					return letters.stream().map(String::valueOf)
							.collect(Collectors.joining());
				}
			}
		}
		return letters.stream().map(String::valueOf)
				.collect(Collectors.joining());
	}
}
