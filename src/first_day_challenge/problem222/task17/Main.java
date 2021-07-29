package first_day_challenge.problem222.task17;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int result = task("+1");
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static int task(String s) {
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		boolean isNegative = s.charAt(0) == '-';
		boolean isPositive = s.charAt(0) == '+';
		if (isNegative||isPositive) {
			s = s.substring(1);
		}

		List<String> number = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			try {
				String currentChar = String.valueOf(s.charAt(i));
				Integer.parseInt(currentChar);
				number.add(String.valueOf(currentChar));
			} catch (Exception e) {
				break;
			}
		}
		
		if (number.isEmpty()) {
			return 0;
		}
		
		try {
			int newInt = Integer.parseInt(String.join("", number));
			if (isNegative) {
				return -newInt;
			} else {
				return newInt;
			}
		} catch (Exception e) {
			if (isNegative) {
				return -(int)Math.pow(2, 31)-1;
			} else {
				return (int)Math.pow(2, 31);
			}
		}
		
	}
}
