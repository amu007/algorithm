package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No328OddEvenOddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean flag = head.val % 2 == 0;

        ListNode dummy = new ListNode(0);
        ListNode point = head;
        ListNode cur = head;
        dummy.next = point;

        while (cur.next != null) {
            if (flag) {
                if (cur.next.val % 2 == 0) {
                    cur = cur.next;
                } else {
                    ListNode temp = cur.next;
                    cur.next = cur.next.next;
                    temp.next = point.next;
                    point.next = temp;

                    point = point.next;
                    cur = point;

                    flag = !flag;
                }
            } else if (!flag) {
                if (cur.next.val % 2 != 0) {
                    cur = cur.next;
                } else {
                    ListNode temp = cur.next;
                    cur.next = cur.next.next;
                    temp.next = point.next;
                    point.next = temp;

                    point = point.next;
                    cur = point;

                    flag = !flag;
                }
            }
        }
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

        No328OddEvenOddEvenLinkedList s = new No328OddEvenOddEvenLinkedList();

        ListNode list = s.oddEvenList(l1);
        Assertions.assertEquals("1#3#5#2#4#", list.toString());
        System.out.println(list);
    }
}
