package link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class No025ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = null;
        ListNode rootLast = null;
        ListNode pre = null;
        ListNode cur = head;
        int i = 0;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            if ((i ++% k == k - 1) || cur == null) {
                if (root == null) {
                    root = pre;

                    while(pre != null) {
                        if (pre.next == null) {
                            rootLast = pre;
                        }
                        pre = pre.next;
                    }
                } else {
                    rootLast.next = pre;
                    while(pre != null) {
                        if (pre.next == null) {
                            rootLast = pre;
                        }
                        pre = pre.next;
                    }
                }
            }
        }

        return root;
    }

//    @Test
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

        No025ReverseNodesInKGroup s = new No025ReverseNodesInKGroup();
//3->2->1->4->5
        ListNode list = s.reverseKGroup(l1, 3);
        Assertions.assertEquals("3#2#1#4#5#", list.toString());
        System.out.println(list);
    }

    @Test
    public void case2() {
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

        No025ReverseNodesInKGroup s = new No025ReverseNodesInKGroup();
//3->2->1->4->5
        ListNode list = s.reverseKGroup(l1, 2);
        Assertions.assertEquals("2#1#4#3#5#", list.toString());
        System.out.println(list);
    }
}
