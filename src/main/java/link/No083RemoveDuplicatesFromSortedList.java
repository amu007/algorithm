package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No083RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        ListNode cur = first;

        while(cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }

        return first;
    }

    @Test
    public void case1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(l1);

        No083RemoveDuplicatesFromSortedList s = new No083RemoveDuplicatesFromSortedList();

        ListNode list = s.deleteDuplicates(l1);
        Assertions.assertEquals("1#2#3#", list.toString());
        System.out.println(list);
    }
    @Test
    public void case2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;

        System.out.println(l1);

        No083RemoveDuplicatesFromSortedList s = new No083RemoveDuplicatesFromSortedList();

        ListNode list = s.deleteDuplicates(l1);
        Assertions.assertEquals("1#2#", list.toString());
    }
    @Test
    public void case3() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;

        System.out.println(l1);

        No083RemoveDuplicatesFromSortedList s = new No083RemoveDuplicatesFromSortedList();

        ListNode list = s.deleteDuplicates(l1);
        Assertions.assertEquals("1#", list.toString());
    }
}
