package binary_search_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	/**
	 *                  5
	 *        3                     6
	 *    2      4             8         0
	 * 1            7             3
	 *                          2
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(5);
		Node node1 = new Node(3);
		Node node2 = new Node(6);
		Node node3 = new Node(2);
		Node node4 = new Node(4);
		Node node5 = new Node(1);
		Node node6 = new Node(7);
		Node node7 = new Node(8);
		Node node8 = new Node(0);
		Node node9 = new Node(3);
		Node node10 = new Node(2);

		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node3.setLeft(node5);
		node4.setRight(node6);
		node2.setLeft(node7);
		node2.setRight(node8);
		node7.setRight(node9);
		node9.setLeft(node10);

		printDFSRecursive(root);
		System.out.println("ready!");
	}

	private static void printDFSRecursive(Node root){
		if (root == null) { return; }

		printDFSRecursive(root.getLeft());
		printDFSRecursive(root.getRight());

		System.out.println(root);
	}

	private static void test(Node root){
		if (root == null) { return; }

		printDFSRecursive(root.getLeft());
		printDFSRecursive(root.getRight());
		System.out.println(root);

	}

	private static void printBFS(Node root){
		Deque<Node> queue = new ArrayDeque<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			System.out.println(currentNode);

			if (currentNode.getLeft() != null){
				queue.offer(currentNode.getLeft());
			}

			if (currentNode.getRight() != null){
				queue.offer(currentNode.getRight());
			}
		}

	}

	private static void printOnlyLeavesRecursive(Node root){
		if (root == null) { return; }

		printOnlyLeavesRecursive(root.getLeft());
		printOnlyLeavesRecursive(root.getRight());

		if (root.getLeft() == null && root.getRight() == null) {
			System.out.println(root);
		}
	}
}
