package util;


public class TreeNodeUtil {
    public static TreeNode renderByInOrder(Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        helper(nums, 1, root);
        return root;
    }

    private static void helper(Integer[] nums, int index, TreeNode ... node) {

        if (node == null || index >= nums.length) {
            return;
        }

        TreeNode[] nodes = new TreeNode[node.length * 2];

//        for (int i = 0; i < node.length; i ++) {
//            if (node[i] == null) {
//                return;
//            }
//            System.out.println(nums[index] + "\t" + (index));
//            node[i].left = nums[index] == null ? null : new TreeNode(nums[index]);
//            index ++;
//
//            System.out.println(nums[index] + "\t" + (index));
//            node[i].right = nums[index] == null ? null : new TreeNode(nums[index]);
//            index ++;
//
//            nodes[i*2 + 0] = node[i].left;
//            nodes[i*2 + 1] = node[i].right;
//        }
        for (int i = 0; i < node.length; i ++) {
            if (node[i] == null) {
                continue;
            }
            if (index >= nums.length) {
                return;
            }
//            System.out.println(nums[index] + "\t" + (index));

            if (nums[index ] != null) {
                node[i].left = new TreeNode(nums[index]);
                nodes[i*2 + 0] = node[i].left;
            }
            index ++;

            if (index >= nums.length) {
                return;
            }

            if (nums[index] != null) {
                node[i].right = new TreeNode(nums[index]);
                nodes[i*2 + 1] = node[i].right;
            }
            index ++;
        }
        helper(nums, index, nodes);

//        node.left = nums[index + 1] == null ? null : new TreeNode(nums[index ++]);
//        node.right = nums[index + 1] == null ? null : new TreeNode(nums[index ++]);
//
//        helper(nums, node.left, index ++ );
//        helper(nums, node.right, index ++);
    }

    public static void main(String[] args) {
//        Integer[] is = new Integer[]{3,4,5,1,3,null,1};
//        Integer[] nums = new Integer[]{};
        Integer[] is = new Integer[]{2,1,3,null,4};
//        Integer[] is = new Integer[]{4,1,null,2};
        TreeNodeUtil.renderByInOrder(is);
    }
}
