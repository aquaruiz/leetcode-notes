package first_day_challenge.problem222.task11;

public class Main {

	public static void main(String[] args) {
		task(new int[][]
			{{1,2,3},
			{4,5,6},
			{7,8,9}});
//		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static void task(int[][] matrix) {
		 int n = matrix[0].length;
		   
		   for (int layer = 0; layer < n/2; layer ++) {
		      for (int i=layer; i<n-layer-1; i++) {
		         //take back before swap
		         int temp = matrix[layer][i];

		         matrix[layer][i] = matrix[n-i-1][layer];
		         matrix[n-i-1][layer] = matrix[n-1-layer][n-i-1];
		         matrix[n-1-layer][n-i-1] = matrix[i][n-1-layer];
		         matrix[i][n-1-layer] = temp;
		      }
		   }
	}

}
