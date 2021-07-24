package task12;

public class Main {

	public static void main(String[] args) {
		task(new char[]	{'h','e','l','l','o'});
//		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static void task(char[] s) {
		int len = s.length;
		for (int i = 0; i < len/2; i++) {
			char temp = s[i];
			s[i] = s[len-1-i];
			s[len-1-i] = temp;
		}
	}

}
