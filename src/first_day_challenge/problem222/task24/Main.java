package first_day_challenge.problem222.task24;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> result = task(new int [] {});
//		System.out.println(result);
		result.stream().forEach(System.out::println);

	}

	private static List<Integer> task(int[] nodes) {
		ListNode prevNode = null;
		for (int i = nodes.length - 1; i >= 0; i--) {
			ListNode currentNode = new ListNode(nodes[i], prevNode);
			prevNode = currentNode;
		}

		ListNode result = reverseNodes(prevNode);
		List<Integer> nodesList = new ArrayList<>();

		if (result == null) {
			return nodesList;
		}

		while (result.next != null) {
			nodesList.add(result.val);
			result = result.next;
		}
		nodesList.add(result.val);
		return nodesList;
	}	
	
	private static ListNode reverseNodes(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		
		while ( current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
}
