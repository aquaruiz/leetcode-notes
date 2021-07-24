package task18;

public class Main {

	public static void main(String[] args) {
		int result = task("mississippi", "issipi");
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static int task(String haystack, String needle) {
		if (needle.length() == 0
				|| needle.equals(haystack)) {
			return 0;
		}
		if (haystack.length() == 0 
				|| haystack.length() < needle.length()){
			return -1;
		}
		
		int index = -1;
		char needleFirstLetter = needle.charAt(0);
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needleFirstLetter) {
				index = i;
				if (needle.length() == 1 ) {
					return index;
				}
				for (int j = 1; j < needle.length(); j++) {
					if (i+j >= haystack.length() ||
							needle.charAt(j) != haystack.charAt(i+j)) {
						index = -1;
						break;
					}
					
					if (j == needle.length() - 1) {
						return index;
					}
				}
			}
		}
		return index;
		
	}
}
