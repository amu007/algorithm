package link.No206ReverseLinkedList;

public class Solution {




    // cur.next, prev, cur = prev, cur, cur.next
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

//    public ListNode reverseList(ListNode head) {
//        ListNode prev = head;
////        ListNode prev = head.next;
//        ListNode cur = prev.next;
//
//        while (cur != null) {
//            prev.next = cur.next;
//            cur.next = head;
//            head = cur;
//            cur = prev.next;
//        }
//        return head;
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Solution solution = new Solution();
        ListNode listNode = solution.reverseList(l1);


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

