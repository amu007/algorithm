package No121BestTimeToBuyAndSellStock;

public class SolutionRecursiveK1 {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 1);
    }

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


        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= kk; k ++) {
                bestProfits[i][0][k] = Math.max(bestProfits[i - 1][1][k] + prices[i], bestProfits[i - 1][0][k]);
                bestProfits[i][1][k] = Math.max(bestProfits[i - 1][0][k - 1] - prices[i], bestProfits[i - 1][1][k]);
            }
        }

        int bestProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            System.out.println(i + "\t" + bestProfits[i][0][kk]);
            bestProfit = Math.max(bestProfits[i][0][kk], bestProfit);
        }
        for (int i = 0; i < prices.length; i++) {
            System.out.println(i + "\t" + bestProfits[i][1][kk]);
        }

        return bestProfit;
    }


    public static void main(String[] args) {
//        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices = new int[]{1,2,3,4,5};
        SolutionRecursiveK1 solution = new SolutionRecursiveK1();
        int bestProfit = solution.maxProfit(prices);

        System.out.println("\n##"+bestProfit);
    }
}
