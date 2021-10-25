package data_structures.linked_list;

public class MyLinkedList {
	Node head;
	int capacity;

	public MyLinkedList() {

	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if (index == 0 || index > capacity) {
			return -1;
		}

		Node currentNode = head;
		while(currentNode.next != null && index > 0) {
			currentNode = currentNode.next;
			index--;
		}

		return currentNode.val;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		capacity++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {

		Node currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}

		Node newNode = new Node(val);
		currentNode.next = newNode;
		capacity++;
	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		Node currentNode = head;
		while(currentNode.next != null && index > 1) {
			currentNode = currentNode.next;
			index--;
		}

		Node temp = currentNode.next;
		currentNode.next = new Node(val);
		currentNode.next.next = temp;
			capacity++;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {

		// todo make it work
		Node currentNode = head;
		while(currentNode.next != null && index > 2) {
			currentNode = currentNode.next;
			index--;
		}

		if (currentNode.next != null) {
		currentNode.val = currentNode.next.val;
		currentNode.next = currentNode.next.next;
		} else {
			currentNode = null;
		}
		capacity--;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append("[");
		Node currentNode = head;
		while(currentNode.next != null) {
			sb.append(currentNode.val).append(", ");
			currentNode = currentNode.next;
		}
		sb.append(currentNode.val);
		sb.append("]");
		return sb.toString();
	}
}
