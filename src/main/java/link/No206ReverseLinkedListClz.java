package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No206ReverseLinkedListClz {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }


        return pre;
    }

    @Test
    public void case1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(l1);

        No206ReverseLinkedListClz s = new No206ReverseLinkedListClz();

        ListNode list = s.reverseList(l1);
        Assertions.assertEquals("6#5#4#3#2#1#", list.toString());
        System.out.println(list);
    }
}
