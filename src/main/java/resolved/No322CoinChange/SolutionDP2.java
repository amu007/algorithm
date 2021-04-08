package resolved.No322CoinChange;

import java.util.Arrays;

public class SolutionDP2 {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < max; i ++) {
            for (int k = 0; k < coins.length; k ++) {
                if (coins[k] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[k]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        SolutionDP2 solution = new SolutionDP2();
//        int min = solution.coinChange(new int[]{1,2,5}, 11);
//        int min = solution.coinChange(new int[]{8,7,6}, 39);
//        int min = solution.coinChange(new int[]{1,8}, 2);
        int min = solution.coinChange(new int[]{2}, 3);

//        int min = solution.coinChange(new int[]{1,2147483647}, 2);
//        int min = solution.coinChange(new int[]{186,419,83,408}, 6249);

//        int min = solution.coinChange(new int[]{474,83,404,3}, 264); // 8
//        int min = solution.coinChange(new int[]{384,324,196,481}, 285); // 8
//        int min = solution.coinChange(new int[]{1}, 0);
//        int min = solution.coinChange(new int[]{1,2,5}, 11);


//        int min = solution.coinChange(new int[]{58,92,387,421,194,208,231}, 7798); // 8
//        int min = solution.coinChange(new int[]{470,18,66,301,403,112,360}, 8235); // 8
//        int min = solution.coinChange(new int[]{3,7,405,436}, 8839); // 25



        System.out.println("RESULT:"+min);
        System.out.println("s" + (System.currentTimeMillis() - time));
    }
}
