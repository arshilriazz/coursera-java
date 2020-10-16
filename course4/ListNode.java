package coursera.course4;

import java.util.*;

public class ListNode<E> {
    public E val;
    public ListNode<E> next, prev;
    public ListNode(E val) { this.val = val; }
    public ListNode() {}

    public static List displayLinkedList(ListNode head) {
        List li = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            li.add(curr.val);
            curr = curr.next;
        }
        return li;
    }
}
