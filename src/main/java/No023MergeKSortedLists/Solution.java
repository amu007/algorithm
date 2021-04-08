package No023MergeKSortedLists;

/*
*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;

        int smallest = Integer.MAX_VALUE;
        int theIndex = -1;
        for (int i = 0; i < lists.length; i ++) {
            if (lists[i] != null) {
                if (lists[i].val < smallest) {
                    smallest = lists[i].val;
                    theIndex = i;
                }
            }
        }
        if (theIndex != -1) {
            root = new ListNode(lists[theIndex].val);
            lists[theIndex] = lists[theIndex].next;
            root.next = mergeKLists(lists);
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next = l32;

        Solution solution = new Solution();
        ListNode result = solution.mergeKLists(new ListNode[]{l11, l21, l31});
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }}