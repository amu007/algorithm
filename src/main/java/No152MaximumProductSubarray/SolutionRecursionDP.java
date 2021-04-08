package No152MaximumProductSubarray;

public class SolutionRecursionDP {
    // Exceed time limit
//    public int maxProduct(int[] nums) {
//        int[][] products = new int[nums.length][nums.length];
//        return helper(nums, 0);
//    }
//
//    public int helper(int[] nums, int start) {
//        if (start >= nums.length) {
//            return Integer.MIN_VALUE;
//        }
//
//        int[] products = new int[nums.length];
//        int product = 1;
//
//        for (int i = start; i < nums.length; i ++) {
//            product *= nums[i];
//            products[i] = product;
//        }
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < products.length; i++) {
//            max = products[i] > max ? products[i] : max;
//        }
//
//        int productNext = helper(nums, start + 1);
//
//        return max > productNext? max : productNext;
//    }
    public int maxProduct(int[] nums) {
        int[][] products = new int[nums.length][2];

        helper(nums, 0, products);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < products.length; i++) {
            int num = 0;
            if (products[i][0] != 0) {
                num = products[i][0];
            } else if (products[i][1] != 0) {
                num = products[i][1];
            }
            max = num > max ? num : max;
        }

        return max;
    }

    public void helper(int[] nums, int start, int[][] products) {
        if (start >= nums.length) {
            return;
        }

        int max = Integer.MIN_VALUE;
        int product = 1;

        for (int i = start; i < nums.length; i ++) {
            product *= nums[i];
            max = product > max ? product : max;
        }
        if (max > 0) {
            products[start][0] = max;
        } else {
            products[start][1] = max;
        }

        helper(nums, start + 1, products);
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,-2,4};
//        int[] nums = new int[]{-2};
        int[] nums = new int[]{-2, 0, -1};

        SolutionRecursionDP solutionRecursionDP = new SolutionRecursionDP();
        int result = solutionRecursionDP.maxProduct(nums);
        System.out.println(result);
    }
}
