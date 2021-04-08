package resolved.No055JumpGame;

class Solution {

    //    SOLUTION 3
    public boolean canJump(int[] nums) {
        int min = -1;
        if (nums.length == 1) {
            return true;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i ++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i-1] - 1, nums[i]);
            }

            if (dp[i] == 0) {
                return false;
            }
        }
        return dp[nums.length - 2] > 0;
    }


//    SOLUTION 2
//    public boolean canJump(int[] nums) {
//        int min = -1;
//        if (nums.length == 1) {
//            return true;
//        }
//
//        int[] dp = new int[nums.length];
//        int times = 1;
//
//        for (int i = 0; i < nums.length - 1; i ++) {
//            for (int k = 0; k < nums[i]; k ++) {
//                if (i + k > nums.length - 1) {
//                    return true;
//                } else {
//                    dp[i + k] = nums[i] - k;
//                }
//            }
//            if (dp[i] == 0) {
//                return false;
//            }
//        }
//        return dp[nums.length - 2] > 0;
//    }

    // SOLUTION 1
//    public boolean canJump(int[] nums) {
//        if (nums.length == 1) {
//            return true;
//        }
//
//        int[] dp = new int[nums.length];
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 0; j < nums[i]; j ++) {
//                if (i + j >= nums.length) {
//                    continue;
//                }
//                // DP formular
//                dp[i + j] = Math.max(dp[i + j], nums[i] - j);
//            }
//            if (dp[i] == 0) {
//                return false;
//            }
//        }
//
//        return dp[nums.length - 2] > 0;
//    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,1,1,4};
//        int[] nums = new int[]{2,1};
//        int[] nums = new int[]{3,2,1,0,4}; //false
//        int[] nums = new int[]{0}; //true
        int[] nums = new int[]{0,1,2}; //false
//        int[] nums = new int[]{2,0,0}; //true

        Solution solution = new Solution();

        System.out.println(solution.canJump(nums));
    }
}
