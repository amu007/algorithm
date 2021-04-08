package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode cur = pre;
        while(cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
//                return pre.next;
            } else {
                cur = cur.next;
            }
        }

        return pre.next;
    }

    @Test
    public void run() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(l1);

        No203RemoveLinkedListElements s = new No203RemoveLinkedListElements();

        ListNode list = s.removeElements(l1, 1);
//        Assertions.assertEquals(3, list.val);
        System.out.println(list);
    }

}
