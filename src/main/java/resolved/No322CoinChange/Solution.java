package resolved.No322CoinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int min = -1;

        Arrays.sort(coins);

        for (int i = coins.length - 1; i >= 0; i --) {
            int tempAmount = amount;
            int coinNum = 0;

            for (int j = i; j >= 0; j --) {
//                if (tempAmount == 0) {
//                    break;
//                }
                coinNum += tempAmount / coins[j];
                tempAmount %= coins[j];
            }

            if (tempAmount != 0) {
                continue;
            }

            if ((min == -1 || coinNum < min)) {
                min = coinNum;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int min = solution.coinChange(new int[]{1,2,5}, 11);
//        int min = solution.coinChange(new int[]{1,6,7}, 30);
//        int min = solution.coinChange(new int[]{2}, 3);

        int min = solution.coinChange(new int[]{186,419,83,408}, 6249);
//        int min = solution.coinChange(new int[]{1}, 0);
        System.out.println(min);
    }
}
