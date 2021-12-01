package others.linked_list;

public class MyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index < 0 || head == null || index + 1 > capacity) {
            return -1;
        }

        Node currentNode = head;
        while (currentNode != tail && index > 0){
            currentNode = currentNode.next;
            index--;
        }

        return currentNode.val;
    }

    public void addAtHead(int val) {

        Node newNode = new Node(val);

        capacity++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        Node oldHead = head;
        newNode.next = head;
        oldHead.prev = newNode;
        head = newNode;
    }

    public void addAtTail(int val) {

        Node newNode = new Node(val);
        capacity++;

        if (tail == null) {
            tail = newNode;
            head = tail;
            return;
        }

        Node oldTail = tail;
        oldTail.next = newNode;
        newNode.prev = oldTail;
        tail = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);

        if (index == capacity){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            capacity++;
            return;
        }

        Node currentNode = head;
        while (currentNode != tail && index > 0) {
            currentNode = currentNode.next;
            index--;
        }

        Node oldCurrent = currentNode;
        newNode.prev = oldCurrent.prev;
        newNode.next = oldCurrent;
        newNode.prev.next = newNode;
        oldCurrent.prev = newNode;
        capacity++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index + 1 > capacity) {
            return;
        }

        capacity--;
        if (index == 0) {
            Node oldHead = head;
            head = oldHead.next;
            if (head == null) {
                tail = head;
            } else {
                head.prev = null;
            }
            return;
        }

        if (index == capacity) {
            Node oldTail = tail;
            tail = oldTail.prev;
            tail.next = null;
            return;
        }

        Node currentNode = head;

        while (currentNode.next != null && index > 0){
            currentNode = currentNode.next;
            index--;
        }

        currentNode.prev.next = currentNode.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        MyLinkedList.Node currentNode = head;
        while(currentNode.next != null) {
            sb.append(currentNode.val).append(", ");
            currentNode = currentNode.next;
        }
        sb.append(currentNode.val);
        sb.append("]");
        return sb.toString();
    }
}