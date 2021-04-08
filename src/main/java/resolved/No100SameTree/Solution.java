package resolved.No100SameTree;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q!= null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }

        if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        Solution solution = new Solution();
        System.out.println(solution.isSameTree(t1, t1));
    }

//    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(0);
//        TreeNode t2 = new TreeNode(-5);
//
//        t1.left = t2;
//
//
//        TreeNode t3 = new TreeNode(0);
//        TreeNode t4 = new TreeNode(-8);
//
//        t3.left = t4;
//
//        SolutionRecursionDP solution = new SolutionRecursionDP();
//        System.out.println(solution.isSameTree(t1, t3));
//    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }