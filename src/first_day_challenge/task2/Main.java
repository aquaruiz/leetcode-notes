package first_day_challenge.task2;

public class Main {

	/**
	 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
	 * Find the maximum profit you can achieve. 
	 * You may complete as many transactions as you like 
	 * (i.e., buy one and sell one share of the stock multiple times).
	 * 
	 * Input: prices = [7,1,5,3,6,4]
	 * Output: 7
	 */
	public static void main(String[] args) {
		int result = task2(new int[] {7,1,5,3,6,4});
		System.out.print(result);
	}

	private static int task2(int[] prices) {
		
		return maxProfit(prices, 0, prices.length-1);
	}

	private static int maxProfit(int[] prices, int start, int end) {
		int profit = 0;
		if (end <= start) {
	        return profit;
		}
		
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j < end + 1; j++) {
				if (prices[j] > prices[i]) {
					int currentProfit = prices[j] - prices[i] 
							+ maxProfit(prices, start, i-1) 
							+ maxProfit(prices, j+1, end);
				
					profit = Math.max(profit, currentProfit);
				}
			}
		}
		
		return profit;
	}
}
