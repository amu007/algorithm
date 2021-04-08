package link.No024SwapNodesInPairs;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; // D->1->2->3->4

        ListNode curr = head; // 1
        ListNode prev = dummy; // D
        while (curr != null && curr.next != null) {
            ListNode next = curr.next; // 2

            curr.next = next.next; // 1->3
            next.next = curr;// 2->1
            prev.next = next; // D->2

            prev = curr; // 1
            curr = curr.next; //3
        }

        return dummy.next;
    }

    public static void main(String[] args) {
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


        Solution solution = new Solution();
        ListNode listNode = solution.swapPairs(l1);


        while(listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}