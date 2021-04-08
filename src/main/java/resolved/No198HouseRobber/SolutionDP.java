package resolved.No198HouseRobber;

public class SolutionDP {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i ++) {
            // dp公式
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i - 1]);
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {2,1,1,2};
        int[] nums = new int[] {7,9,2};

        SolutionDP solution = new SolutionDP();
        int max = solution.rob(nums);
        System.out.println(max);
    }
}
