package resolved.No213HouseRobberII;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
//        System.out.println(helper(nums, 0, nums.length - 1));
        System.out.println(helper(nums, 1, nums.length));
        return Math.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }

    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];

        dp[0 + start] = nums[start];
        dp[1 + start] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end; i ++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i - 1]);
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,7,9,2};

        Solution solution = new Solution();
        int max = solution.rob(nums);
        System.out.println(max);
    }
}
