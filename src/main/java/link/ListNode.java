package link;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {

        ListNode cur = this;
        String str = "";
        str += cur.val + "#";
        while(cur.next != null) {
            cur = cur.next;
            str += cur.val + "#";
        }

        return str;
    }
}
