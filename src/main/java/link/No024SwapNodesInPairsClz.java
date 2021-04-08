package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No024SwapNodesInPairsClz {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, cur = head;

        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            prev.next = next;

            prev = cur;
            cur = cur.next;
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

        No024SwapNodesInPairsClz s = new No024SwapNodesInPairsClz();

        ListNode list = s.swapPairs(l1);
        Assertions.assertEquals("2#1#4#3#5#", list.toString());
        System.out.println(list);
    }

}
