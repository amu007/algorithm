package No121BestTimeToBuyAndSellStock;

import java.util.Arrays;

public class SolutionRecursiveK {
    public int maxProfit(int[] prices, int kk) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //[][0]表示清仓状态 也为卖出状态
        //[][1]表示满仓状态 也为买入状态
        //[][][k] 第三维表示第1次交易
        int[][][] bestProfits = new int[prices.length][2][kk + 1];

        bestProfits[0][0][0] = 0;
        bestProfits[0][1][1] = 0 - prices[0];

        int bestProfit = 0;
//        1) dp[i][0][k] = MAX{ dp[i - 1][0][k], dp[i - 1][1][k - 1] + a[i]};
//        2) dp[i][1][k] = MAX{ dp[i - 1][1][k], dp[i - 1][0][k] - a[i]};
        for (int i = 1; i < prices.length; i++) {
            System.out.println(i);
            for (int k = 1; k <= kk; k ++) {
                bestProfits[i][1][k] =
                        k == 1 ? Math.max(bestProfits[i - 1][1][k], 0 - prices[i]):
                        Math.max(bestProfits[i-1][0][k] - prices[i], bestProfits[i - 1][1][k]);

                    bestProfits[i][0][k] =
                            k == 1 ?
                                    bestProfits[i][1][k] + prices[i]:
                                    Math.max(bestProfits[i - 1][0][k], bestProfits[i - 1][1][k - 1] + prices[i]);
//                System.out.println("i:" + i + "\tk:" + k + "\tbuy:" + bestProfits[i - 1][1][k] + "\t" + prices[i] + "\tNbuy:" + bestProfits[i - 1][0][k] + "\tbest:" + bestProfits[i][0][k]);
                    bestProfit = Math.max(bestProfit, bestProfits[i][0][k]);
//                }


            }
        }

        System.out.println("###0");
        for (int k = 0; k <= kk; k ++) {
            System.out.println();
            for (int i = 0; i < prices.length; i ++) {
                System.out.print(bestProfits[i][0][k] + "\t");
            }
        }
        System.out.println("###1");
        for (int k = 0; k <= kk; k ++) {
            System.out.println();
            for (int i = 0; i < prices.length; i ++) {
                System.out.print(bestProfits[i][1][k] + "\t");
            }
        }

        return bestProfit;
    }


    public static void main(String[] args) {
//        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{1,2,3,4,5};
//        int[] prices = new int[]{5,4,3,2,1};
//        [6,1,3,2,4,7]
        int[] prices = new int[]{6,1,3,2,4,7};
        SolutionRecursiveK solution = new SolutionRecursiveK();
//        int bestProfit = solution.maxProfit(prices, prices.length);
        int bestProfit = solution.maxProfit(prices, 2);

        System.out.println("\n##"+bestProfit);
    }
}
