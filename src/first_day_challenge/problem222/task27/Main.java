package first_day_challenge.problem222.task27;

import first_day_challenge.problem222.task29.TreeNode;

public class Main {

	public static void main(String[] args) {
		int result = task(new Integer [] {});
		System.out.println(result);
//		result.stream().forEach(System.out::println);

	}

	private static Integer task(Integer[] nodes) {
		if (nodes.length == 0) {
			return 0;
		}
		TreeNode root = arrayToTree(nodes, 0);
		return maxDepth(root);
	}	
	
	private static TreeNode arrayToTree(Integer array[], int index) {
		if (index >= array.length) {
	        return null;
		}
	    if (array[index] == null) {
	        return null;
	    }
	    return new TreeNode(
	    		array[index], 	
	    		arrayToTree(array, index * 2 + 1), 
	    		arrayToTree(array, index * 2 + 2));
	}

	private static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}