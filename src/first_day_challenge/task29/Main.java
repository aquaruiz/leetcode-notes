package first_day_challenge.task29;

public class Main {

	public static void main(String[] args) {
		boolean result = task(new Integer [] {1,2,2,null,3,null,3});
		System.out.println(result);
//		result.stream().forEach(System.out::println);

	}

	private static boolean task(Integer[] nodes) {
		if (nodes.length == 0) {
			return false;
		}
		TreeNode root = arrayToTree(nodes, 0);
		return isSymmetric(root);
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

	private static boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private static boolean isSymmetric(TreeNode firstNode, TreeNode secondNode) {
		if (firstNode == null && secondNode == null) {
			return true;
		}
		
		if (firstNode != null
				&& secondNode != null
				&& firstNode.val == secondNode.val) {
			
			return isSymmetric(firstNode.left, secondNode.right)
					&& isSymmetric(firstNode.right, secondNode.left);
		}
		
		return false;
	}
}