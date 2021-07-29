package first_day_challenge.problem222.task22a;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> result = task(new int[] { 1,2 }, 2);
//		System.out.println(result);
		result.stream().forEach(System.out::println);
	}

	private static List<Integer> task(int[] nodes, int delNode) {
		ListNode prevNode = null;
		for (int i = nodes.length - 1; i >= 0; i--) {
			ListNode currentNode = new ListNode(nodes[i], prevNode);
			prevNode = currentNode;
		}

		ListNode result = removeNthFromEnd(prevNode, delNode);
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

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tailWannaBe = head;
		ListNode toRemove = head;
		
		for (int i = 0; i < n; i++) {
			tailWannaBe = tailWannaBe.next;
		}

		if (n == 1) {
			if (tailWannaBe == null) {
				return null;
			}
			while (tailWannaBe.next != null) {
				toRemove = toRemove.next;
				tailWannaBe = tailWannaBe.next;
			}
			toRemove.next = toRemove.next.next;

		} else {
			while (tailWannaBe != null) {
				toRemove = toRemove.next;
				tailWannaBe = tailWannaBe.next;
			}
			
			toRemove.val = toRemove.next.val;
			toRemove.next = toRemove.next.next;
		}
		return head;
	}
}
