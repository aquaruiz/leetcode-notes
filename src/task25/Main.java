package task25;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		boolean result = task(new int [] {1,3});
		System.out.println(result);
//		result.stream().forEach(System.out::println);

	}

	private static boolean task(int[] nodes1) {
		ListNode prevNode1 = null;
		for (int i = nodes1.length - 1; i >= 0; i--) {
			ListNode currentNode = new ListNode(nodes1[i], prevNode1);
			prevNode1 = currentNode;
		}
		
		boolean result = isPalindrome(prevNode1);
		return result;
//		List<Integer> nodesList = new ArrayList<>();
//
//		if (result == null) {
//			return nodesList;
//		}
//
//		while (result.next != null) {
//			nodesList.add(result.val);
//			result = result.next;
//		}
//		nodesList.add(result.val);
//		return nodesList;
	}	
	
	private static boolean isPalindrome(ListNode head) {
		List<ListNode> nodes = new ArrayList<>();
		ListNode currentNode = head;
		while (currentNode != null) {
			nodes.add(currentNode);
			currentNode = currentNode.next;
		}
		
		for (int i = nodes.size() - 1; i >= 0; i--) {
			if (nodes.get(i).val != head.val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
}
