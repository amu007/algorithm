package resolved.No628MaximumProductOfThreeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int length = nums.length;

        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= length - 2; i ++) {
            int data = nums[i] * nums[i - 1];
            max = Math.max(max, data);
        }

        return nums[length-1]*max;
    }
//    public int maximumProduct(int[] nums) {
//        if (nums == null || nums.length < 3) {
//            return 0;
//        }
//        int length = nums.length;
//
//        Arrays.sort(nums);
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i <= length - 2; i ++) {
//            for (int j = 0; j < ; j++) {
//                if (i != j) {
//
//                }
//            }
//            int data = nums[i] * nums[i - 1];
//            max = Math.max(max, data);
//        }
//
//        return nums[length-1]*max;
//    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[]{5,6,7,3,2,1};
//        solution.maximumProduct(nums);
//    }
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = new int[]{5,6,7,3,2,1};
        int result = solution.maximumProduct(nums);
        Assertions.assertEquals(210, result);

        nums = new int[]{-4,-3,-2,-1,60};
        result = solution.maximumProduct(nums);
        Assertions.assertEquals(720, result);

    }

}
