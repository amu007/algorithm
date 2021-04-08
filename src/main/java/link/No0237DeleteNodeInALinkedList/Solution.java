package link.No0237DeleteNodeInALinkedList;

import link.ListNode;
import org.junit.jupiter.api.Test;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    @Test
    public void run() {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
    }
}
