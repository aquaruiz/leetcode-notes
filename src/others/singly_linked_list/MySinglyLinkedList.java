package others.singly_linked_list;

public class MySinglyLinkedList {

	class Node {

		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	Node head;
	int capacity;

	public MySinglyLinkedList() {
	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if (index < 0 || index > capacity) {
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
		if (get(index) == -1 || index > capacity) {
			return;
		}

		if (index == 0){
			head = head.next;
			return;
		}

		capacity--;

		Node currentNode = head;

		while(currentNode.next != null && index > 1) {
			currentNode = currentNode.next;
			index--;
		}

		Node toDelete = currentNode.next;
		currentNode.next = toDelete.next;
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
