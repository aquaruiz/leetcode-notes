package task19;

public class Main {

	public static void main(String[] args) {
		String result = task(4);
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static String task(int n) {
		String result = "1";
		for (int i = 1; i < n; i++) {
			result = lokkAndSay(result);
		}
		
		return result;
	}

	private static String lokkAndSay(String number) {
		
		StringBuilder sBuilder = new StringBuilder();
		char repeat = number.charAt(0);
		number = number.substring(1) + " ";
		int times = 1;
	 
		for(char actual: number.toCharArray()){
			if(actual != repeat){
				sBuilder.append(times + "" + repeat);
				times = 1;
				repeat = actual;
			} else {
				times += 1;
			}
		}
		return sBuilder.toString();
	}
}
