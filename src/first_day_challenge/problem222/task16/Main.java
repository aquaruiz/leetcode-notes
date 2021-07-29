package first_day_challenge.problem222.task16;

public class Main {

	public static void main(String[] args) {
		boolean result = task("A8 man, a plan, a canal: Panam85a");
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static boolean task(String s) {
		s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
