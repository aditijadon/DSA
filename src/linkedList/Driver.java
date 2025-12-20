package linkedList;

public class Driver {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        LinkedList l = new LinkedList();
        System.out.print("Given Linked list:");
        l.printList(head);
        System.out.print("\nReversed Linked List:");
        l.printList(l.reverseList(head));
        System.out.println();
        System.out.println("Middle Node is: " + l.getMiddle(head));
        System.out.print("After Delete:");
        l.printList(l.deleteNode(head, 3));
        System.out.println();

        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        System.out.print("Sorted List 1:");
        l.printList(head1);
        System.out.println();
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);
        System.out.print("Sorted List 2:");
        l.printList(head2);
        System.out.println();
        Node res = l.sortedMerge(head1, head2);
        System.out.print("Merged Sorted List:");
        l.printList(res);
    }
}
