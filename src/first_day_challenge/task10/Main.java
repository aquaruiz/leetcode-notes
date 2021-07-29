package first_day_challenge.task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		boolean result = task(new char[][]
			{{'8','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}});
		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static boolean task(char[][] board) {
		HashMap<Integer, List<Character>> rows = new HashMap<>();
		HashMap<Integer, List<Character>> cols = new HashMap<>();
		HashMap<Integer, List<Character>> blocks = new HashMap<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				char currentChar = board[i][j];
				if (currentChar == '.') {
					continue;
				} else {
					int rowNumber = i;
					int colNumber = j;
					int blockNumber = calcBlock(i, j);
					
					rows.putIfAbsent(rowNumber, new ArrayList<>());					
					cols.putIfAbsent(colNumber, new ArrayList<>());					
					blocks.putIfAbsent(blockNumber, new ArrayList<>());
					
					if (rows.get(rowNumber).contains(currentChar)
							|| cols.get(colNumber).contains(currentChar)
							|| blocks.get(blockNumber).contains(currentChar)) {
						return false;
					}
					
					rows.get(rowNumber).add(currentChar);
					cols.get(colNumber).add(currentChar);
					blocks.get(blockNumber).add(currentChar);
				}
			}
		}
		
		return true;
	}

	private static int calcBlock(int row, int col) {
		if (row < 3 && col < 3) {
			return 0;
		} 
		if (row < 3 && col < 6) {
			return 1;
		}
		if (row < 3 && col < 9) {
			return 2;
		}
		if (row < 6 && col < 3) {
			return 3;
		}
		if (row < 6 && col < 6) {
			return 4;
		}
		if (row < 6 && col < 9) {
			return 5;
		}
		if (row < 9 && col < 3) {
			return 6;
		}
		if (row < 9 && col < 6) {
			return 7;
		}
		if (row< 9 && col < 9) {
			return 8;
		}
		return 9;
	}

}
