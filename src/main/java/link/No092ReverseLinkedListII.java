package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No092ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
//        ListNode cur = head;
//
//        int i = 1;
//
//        while (cur != null) {
//            if (i >= m && i <= n) {
//                ListNode temp = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = temp;
//                i ++;
//            } else {
//                ListNode temp = cur.next;
//                cur.next = null;
//                pre.next = cur;
//                pre = cur;
//                cur = temp;
//                i ++;
//            }
//        }

        return pre;
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

        No092ReverseLinkedListII s = new No092ReverseLinkedListII();

        ListNode list = s.reverseBetween(l1,10 ,11);
        Assertions.assertEquals("1#4#3#2#5#", list.toString());
        System.out.println(list);
    }
}
