package resolved.No337HouseRobberIII;

import util.TreeNode;
import util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 f1(node) be the value of maximum money we can rob from the subtree with node as root ( we can rob node if necessary).

 f2(node) be the value of maximum money we can rob from the subtree with node as root but without robbing node.

 Then we have

 f2(node) = f1(node.left) + f1(node.right) and

 f1(node) = max( f2(node.left)+f2(node.right)+node.value, f2(node) ).1
 */
class Solution {
    public int rob(TreeNode root) {
        return robDFS(root)[1];
    }
    int[] robDFS(TreeNode node){
        int [] res = new int[2];
        if(node==null) return res;
        int [] l = robDFS(node.left);
        int [] r = robDFS(node.right);
        res[0] = l[1] + r[1];
        res[1] = Math.max(res[0], l[0] + r[0] + node.val);
        return res;
    }
//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return root.val;
//        }
//        int[] result = new int[100];
//
//        result[0] = root.val;
//        List<TreeNode> nodes = new ArrayList<>();
//        if (root.left != null) {
//            result[1] += root.left.val;
//            nodes.add(root.left);
//
////            if (root.left.left != null) {
////                nodes.add(root.left.left);
////            }
////            if (root.left.right != null) {
////                nodes.add(root.left.right);
////            }
//        }
//        if (root.right != null) {
//            result[1] += root.right.val;
//            nodes.add(root.right);
//
////            if (root.right.left != null) {
////                nodes.add(root.right.left);
////            }
////            if (root.right.right != null) {
////                nodes.add(root.right.right);
////            }
//        }
//        result[1] = Math.max(result[0], result[1]);
//
//        int level = 1;
//        blt(nodes, level, result);
////        return rob(result);
//        int max = 0;
//        for (int i = 0; i < result.length; i ++) {
//            max = Math.max(max, result[i]);
//        }
//        return max;
//    }

//    public void blt(List<TreeNode> roots, int level, int[] result) {
//        if (roots.size() == 0) {
//            return;
//        }
//
//        int levelSum = 0;
////        System.out.println(level);
//        List<TreeNode> nodes = new ArrayList<>();
//        for (int i = 0; i < roots.size(); i++) {
//            if (roots.get(i).left != null) {
//                nodes.add(roots.get(i).left);
//            }
//            if (roots.get(i).right != null) {
//                nodes.add(roots.get(i).right);
//            }
//        }
//        int nextLevelSum = 0;
//
//        for (int i = 0; i < nodes.size(); i ++) {
//            nextLevelSum += nodes.get(i).val;
//        }
//
//        int maxInNode = 0;
//        for (int i = 0; i < roots.size(); i++) {
//            int curNodeSum = 0;
//            if (roots.get(i).left != null) {
//                curNodeSum += roots.get(i).left.val;
//            }
//            if (roots.get(i).right != null) {
//                curNodeSum += roots.get(i).right.val;
//            }
//            if (nextLevelSum != 0) {
//                System.out.println(nextLevelSum - curNodeSum + roots.get(i).val);
//                maxInNode = Math.max(nextLevelSum - curNodeSum + roots.get(i).val, maxInNode);
////                System.out.println((result[level - 1] + nextLevelSum) +"\t"+ (nextLevelSum - curNodeSum + roots.get(i).val));
////                result[level] =
////                        Math.max(
////                        Math.max(result[level - 1] + nextLevelSum, nextLevelSum - curNodeSum + roots.get(i).val),
////                        result[level]);
//            }
//        }
//
//        result[level + 1] = Math.max(result[level - 1] + maxInNode, result[level]);
////        result[level + 1] = Math.max(maxInNode, result[level - 1] + nextLevelSum);
//        ++level;
//        blt(nodes, level, result);
//    }


    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{3,4,5,1,3,null,1};

//        Integer[] nums = new Integer[]{4,1,null,2,null,3};
//        Integer[] nums = new Integer[]{2,3,1,null,4};
//        Integer[] nums = new Integer[]{1,null,2};
//        Integer[] nums = new Integer[]{6,3,2};
        Integer[] nums = new Integer[]{1,3,4};
//        Integer[] nums = new Integer[]{4,1,null,2,null,3,null,7};
//        Integer[] nums = new Integer[]{4,2,null,3,1,null,null,5}; //12
//        Integer[] nums = new Integer[]{3,2,3,null,3,null,1}; //7

        TreeNode root = TreeNodeUtil.renderByInOrder(nums);

        Solution solution = new Solution();
        int result = solution.rob(root);
        System.out.println(result);
    }
}
