package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No328OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        ListNode dummy = new ListNode(0);
        dummy.next = odd;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return dummy.next;
    }

    @Test
    public void case1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(l1);

        No328OddEvenLinkedList s = new No328OddEvenLinkedList();

        ListNode list = s.oddEvenList(l1);
        Assertions.assertEquals("1#3#5#2#4#", list.toString());
        System.out.println(list);
    }
}
