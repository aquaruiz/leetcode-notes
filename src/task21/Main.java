package task21;

public class Main {

	public static void main(String[] args) {
		task(new int [] {4,5,1,9}, 5);
//		System.out.println(result);
//		Arrays.stream(result).forEach(System.out::println);

	}

	private static void task(int[] node, int delNode) {
		
	}	
	
	private static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
