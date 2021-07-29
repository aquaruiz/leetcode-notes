package first_day_challenge.problem222.task28;

import first_day_challenge.problem222.task29.TreeNode;

public class Main {

	public static void main(String[] args) {
		boolean result = task(new Integer [] {2,2,2});
		System.out.println(result);
//		result.stream().forEach(System.out::println);

	}

	private static boolean task(Integer[] nodes) {
		if (nodes.length == 0) {
			return false;
		}
		TreeNode root = arrayToTree(nodes, 0);
		return isValidBST(root);
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

	private static boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	private static boolean isValidBST(TreeNode node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}
		if ((min != null && node.val <= min)
				|| max != null && node.val >= max) {
			return false;
		}
		
		return isValidBST(node.left, min, node.val) 
				&& isValidBST(node.right, node.val, max);
	}
}