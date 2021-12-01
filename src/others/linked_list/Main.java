package others.linked_list;

public class Main {
    public static void main(String[] args) {

        //Your MyLinkedList object will be instantiated and called as such:
        MyLinkedList obj = new MyLinkedList();
//        obj.addAtHead(5);
//        int param_1 = obj.get(1);
//        System.out.println(param_1);
//        obj.addAtHead(10);
//        obj.addAtTail(20);
//        obj.addAtTail(50);
//        obj.addAtIndex(1, 7);
//        int param2 = obj.get(2);
//        System.out.println(param2);
//        System.out.println(obj);
//
//        obj.deleteAtIndex(1);
//        System.out.println(obj);

        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//        System.out.println(myLinkedList);
//        System.out.println(myLinkedList.get(1));              // return 2
//        myLinkedList.deleteAtIndex(20);    // now the linked list is 1->3
//        System.out.println(myLinkedList);
//        System.out.println(myLinkedList.get(1));              // return 3
        myLinkedList.addAtHead(7);
//        myLinkedList.addAtTail(0);
        myLinkedList.deleteAtIndex(0);
//        myLinkedList.addAtTail(5);
        System.out.println(myLinkedList);
    }
}
