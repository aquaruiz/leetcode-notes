package task23;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> result = task(new int [] {1,3}, new int [] {1,3});
//		System.out.println(result);
		result.stream().forEach(System.out::println);

	}

	private static List<Integer> task(int[] nodes1,int[] nodes2) {
		ListNode prevNode1 = null;
		for (int i = nodes1.length - 1; i >= 0; i--) {
			ListNode currentNode = new ListNode(nodes1[i], prevNode1);
			prevNode1 = currentNode;
		}
		
		ListNode prevNode2 = null;
		for (int i = nodes2.length - 1; i >= 0; i--) {
			ListNode currentNode = new ListNode(nodes1[i], prevNode2);
			prevNode2 = currentNode;
		}
		
		ListNode result = mergeTwoLists(prevNode1, prevNode2);
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
	
	private static ListNode mergeTwoLists(ListNode firstHead, ListNode secondHead) {
		if (firstHead == null && secondHead == null) {
			return null;
		} else if (firstHead == null) {
			return secondHead;
		} else if (secondHead == null) {
			return firstHead;
		}
		ListNode newHead = new ListNode();
		if (firstHead.val < secondHead.val) {
			newHead.val = firstHead.val;
			if (firstHead.next != null) {
				firstHead.val = firstHead.next.val;
				firstHead.next = firstHead.next.next;
			} else {
				firstHead = null;
			}
		} else {
			newHead.val = secondHead.val;
			if (secondHead.next != null) {
				secondHead.val = secondHead.next.val;
				secondHead.next = secondHead.next.next;
			} else {
				secondHead = null;
			}
		}	
		ListNode sorted = newHead;
		while (firstHead != null && secondHead != null) {
			ListNode newNode = new ListNode();
			if (firstHead.val < secondHead.val) {
				newNode.val = firstHead.val;
				if (firstHead.next != null) {
					firstHead.val = firstHead.next.val;
					firstHead.next = firstHead.next.next;
				} else {
					firstHead = null;
				}
			} else {
				newNode.val = secondHead.val;
				if (secondHead.next != null) {
					secondHead.val = secondHead.next.val;
					secondHead.next = secondHead.next.next;
				} else {
					secondHead = null;
				}
			}	
			
			sorted.next = newNode;
			sorted = sorted.next;
		}
		
		if (firstHead != null) {
			sorted.next = firstHead;
		}
		if (secondHead != null) {
			sorted.next =secondHead;
		}
		return newHead;
	}
}