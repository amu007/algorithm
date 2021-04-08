package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No082RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next.next;
                while (temp.next != null &&temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

    @Test
    public void case1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println(l1);

        No082RemoveDuplicatesFromSortedListII s = new No082RemoveDuplicatesFromSortedListII();

        ListNode list = s.deleteDuplicates(l1);
        Assertions.assertEquals("2#3#", list.toString());
        System.out.println(list);
    }
//1->2->3->3->4->4->5
    @Test
    public void case2() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        System.out.println(l1);

        No082RemoveDuplicatesFromSortedListII s = new No082RemoveDuplicatesFromSortedListII();

        ListNode list = s.deleteDuplicates(l1);
        Assertions.assertEquals("1#2#5#", list.toString());
        System.out.println(list);
    }
}
