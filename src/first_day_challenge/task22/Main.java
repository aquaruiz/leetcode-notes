package first_day_challenge.task22;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> result = task(new int[] { 1, 2, 3, 4, 5 }, 2);
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
		if (head.next == null) {
			return null;
		}
		ListNode toRemove = head;
		ListNode tailWannabe = head;

		for (int i = 0; i < 30; i++) {
			if (i >= n-1) {
				toRemove = toRemove.next;
			}
			tailWannabe = tailWannabe.next;
			if (tailWannabe.next == null) {
				break;
			}
		}

		if (n == 1) {
			toRemove.next = null;
		} else {
			if (toRemove.next != null) {
				toRemove.val = toRemove.next.val;
				toRemove.next = toRemove.next.next;
			}
		}
		return head;
	}
}
