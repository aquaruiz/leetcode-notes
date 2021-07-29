package first_day_challenge.problem222.task13;

public class Main {

	public static void main(String[] args) {
		int result = task(1534236469);
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static int task(int x) {
		boolean isNegative = Math.abs(x) != x;
		char[] number = String.valueOf(Math.abs(x)).toCharArray();

		for (int i = 0; i < number.length/2; i++) {
			char temp = number[i];
			number[i] = number[number.length-1-i];
			number[number.length-1-i] = temp;
		}
		
		try {
			int newInt = Integer.parseInt(new String(number));
			if (isNegative) {
				return -newInt;
			}
			return newInt;
		} catch (Exception e) {
			return 0;
		}
	}

}
