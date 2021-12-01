package others.singly_linked_list;

public class Main {
	public static void main(String[] args) {
		MySinglyLinkedList obj = new MySinglyLinkedList();
		int result = obj.get(1);
		System.out.println(result);
		obj.addAtHead(1);
		obj.addAtTail(3);
		obj.addAtIndex(1, 2);
		System.out.println(obj);
		int result2 = obj.get(0);
		System.out.println(result2);
		obj.deleteAtIndex(0);
		System.out.println(obj);
	}

}
