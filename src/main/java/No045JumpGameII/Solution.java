package No045JumpGameII;

class Solution {

//    public int jump(int[] nums) {
//        if (nums.length == 1) {
//            return 1;
//        }
//
//        int[][] dp = new int[nums.length][2];
//
//        for (int i = 0; i < nums.length - 1; i ++) {
//            if (i == 0) {
//                dp[i][0] = nums[i];
//                dp[i][1] = 1;
//            } else {
//                dp[i][1] = nums[i] > dp[i-1][0] - 1 ? dp[i][1] = dp[i-1][1] + 1 : dp[i-1][1];
//                dp[i][0] = Math.max(dp[i-1][0] - 1, nums[i]);
//            }
//            if (dp[i][0] == 0) {
//                return -1;
//            }
//        }
//        return dp[nums.length - 2][1];
//    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int lastReach = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i <= reach && i < nums.length; i++)
        {
            if (i > lastReach)
            {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }

        if (reach < nums.length - 1)
            return 0;
        return step;
    }

//    public int jump(int[] nums) {
//        if (nums.length == 1) {
//            return 0;
//        }
//
//        int times = 1;
//        int length = nums.length - 1;
//
//        for (int i = 0; i < nums.length - 1; ) {
//            if (nums[i] + i >= length) {
//                return times;
//            }
//            int max = 0 - length, maxIndex = -1;
//            for (int j = i; j <= nums[i]; j ++) {
//                int distance = nums[j] + j;
//                if (distance >= length) {
//                    return times + 1;
//                }
//                System.out.println(j + "\t" + distance + "");
//                if (distance >= max) {
//                    max = distance;
//                    maxIndex = j;
//                }
//            }
//            i = maxIndex;
//            times ++;
//        }
//        return times;
//    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,1,1,4}; // 2
//        int[] nums = new int[]{2,1}; // 1
//        int[] nums = new int[]{3,2,1,0,4}; //-1
//        int[] nums = new int[]{0}; // 1
//        int[] nums = new int[]{0,1,2}; //false
//        int[] nums = new int[]{2,0,0}; //1
//        int[] nums = new int[]{2,1}; //1
//        int[] nums = new int[]{2,3,1}; //1
//        int[] nums = new int[]{1,2,3}; //2

//        int[] nums = new int[]{1,2,1,1,1}; // 3
//        int[] nums = new int[]{11,2,1,1,1}; // 1
//        int[] nums = new int[]{2,0,2,4,6,0,0,3}; //3

        int[] nums = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}; //2

        Solution solution = new Solution();

        System.out.println(solution.jump(nums)+"");
    }
}
