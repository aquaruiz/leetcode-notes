package first_day_challenge.problem222.task26;

import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		boolean result = task(new int [] {3,2,0,-4}, 1);
		System.out.println(result);
//		result.stream().forEach(System.out::println);

	}

	private static boolean task(int[] nodes1, int pos) {
		ListNode prevNode1 = null;
		ListNode linkedTo = null;
		ListNode tail = null;
		for (int i = nodes1.length - 1; i >= 0; i--) {
			ListNode currentNode = new ListNode(nodes1[i], prevNode1);
			prevNode1 = currentNode;
			if (pos == i) {
				linkedTo = currentNode;
			}
			if (i == nodes1.length - 1) {
				tail = currentNode;
			}
		}
		
		tail.next = linkedTo;
		boolean result = hasCycle(prevNode1);
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
	
	private static boolean hasCycle(ListNode head) {
		HashSet<String> toStrings = new HashSet<String>();
		while (head != null) {
			String currentToString = head.toString();
			if (toStrings.contains(currentToString)) {
				return true;
			}
			toStrings.add(currentToString);
			head = head.next;
		}
		return false;
	}
}
