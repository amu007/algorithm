package resolved.No322CoinChange;

import java.util.Arrays;

public class Solution2 {

    public int[][] cache;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        cache = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length/2; i ++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - 1 - i];
            coins[coins.length - 1 - i] = temp;
        }

        for (int i = 0; i < coins.length; i++) {
//            System.out.println("\t" + coins[i]);
        }

        return helper(coins,amount);
    }

    public int helper(int[] coins, int amount) {
//        System.out.println(amount);
        if (amount == 0) {
            return 0;
        } else if (coins.length == 0) {
            return -1;
        }
        int num0 = coins[0];
        if (coins.length == 1 && num0 > amount) {
            return -1;
        }
        int div0 = amount / num0;
        int min = amount % num0 == 0 ? div0 : Integer.MAX_VALUE;

        if (coins.length == 1) {
            return amount % num0 == 0 ? div0 : -1;
        }


        int[] restCoins = new int[coins.length - 1];
        for (int k = 1; k < coins.length; k ++) {
            restCoins[k - 1] = coins[k];
        }

        for (int i = div0; i >= 0; i --) {
            int num = cache[restCoins.length][amount - (i * num0)];
            if (cache[restCoins.length][amount - (i * num0)] == 0) {
                num = helper(restCoins, amount - (i * num0));
            }
            cache[restCoins.length][amount - (i * num0)] = num;

//            int num = helper(restCoins, amount - (i * num0));
            if (num != -1 && num != Integer.MAX_VALUE) {
//                System.out.println((i + num) + "\t" + min);
                min = Math.min(i + num, min);
            }
        }

//        System.out.println(coins.length+"\t#" + min);
        return min == Integer.MAX_VALUE ? -1 : min;

    }


    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Solution2 solution = new Solution2();
//        int min = solution.coinChange(new int[]{1,2,5}, 11);
//        int min = solution.coinChange(new int[]{8,7,6}, 36);
//        int min = solution.coinChange(new int[]{1,8}, 2);
//        int min = solution.coinChange(new int[]{2}, 3);

//        int min = solution.coinChange(new int[]{1,2147483647}, 2);
//        int min = solution.coinChange(new int[]{186,419,83,408}, 6249);

//        int min = solution.coinChange(new int[]{474,83,404,3}, 264); // 8
//        int min = solution.coinChange(new int[]{384,324,196,481}, 285); // 8
//        int min = solution.coinChange(new int[]{1}, 0);
//        int min = solution.coinChange(new int[]{1,2,5}, 11);


//        int min = solution.coinChange(new int[]{58,92,387,421,194,208,231}, 7798); // 8
//        int min = solution.coinChange(new int[]{470,18,66,301,403,112,360}, 8235); // 8
        int min = solution.coinChange(new int[]{3,7,405,436}, 8839); // 25



        System.out.println("RESULT:"+min);
        System.out.println("s" + (System.currentTimeMillis() - time));
    }
}
