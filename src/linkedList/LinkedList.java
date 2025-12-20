package linkedList;

public class LinkedList {
    static Node reverseList(Node head) {
        Node curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static int getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    static boolean hasCycle(Node head) {
        Node slow_ptr = head;
        Node fast_ptr = head;
        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;

            if(fast_ptr == slow_ptr) return true;
        }
        return false;
    }

    static Node sortedMerge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.data <= head2.data) {
            head1.next = sortedMerge(head1.next, head2);
            return head1;
        }
        else {
            head2.next = sortedMerge(head1, head2.next);
            return head2;
        }
    }

    static Node deleteNode(Node head, int position){
        Node temp = head;
        Node prev = null;

        if (temp == null)
            return head;

        if (position == 1) {
            head = temp.next;
            return head;
        }

        for (int i = 1; temp != null && i < position; i++) {
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

//    static Node removeNthNodeFromBack(Node head, int n){
//
//    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }
}
