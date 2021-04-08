package No121BestTimeToBuyAndSellStock;

public class SolutionRecursive {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //[][0]表示清仓状态 也为卖出状态
        //[][1]表示满仓状态 也为买入状态
        //[][][k] 第三维表示第1次交易
        int[][] bestProfits = new int[prices.length][2];

        bestProfits[0][0] = 0;
        bestProfits[0][1] = 0 - prices[0];

        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            for (int k = 0; k < 2; k ++) {
                bestProfits[i][0] = Math.max(bestProfits[i - 1][1] + prices[i], bestProfits[i - 1][0]);
//                bestProfits[i][1] = Math.max(bestProfits[i - 1][0] - prices[i], bestProfits[i - 1][1]);
                bestProfits[i][1] = Math.max(0 - prices[i], bestProfits[i - 1][1]);
            }

            bestProfit = Math.max(bestProfit, Math.max(bestProfits[i][0], bestProfits[i][1]));
        }

//        for (int j = 0; j < prices.length; j++) {
//            System.out.print(bestProfits[j][0] + "\t");
//        }System.out.println("\n");
//        for (int j = 0; j < prices.length; j++) {
//            System.out.print(bestProfits[j][1] + "\t");
//        }

        return bestProfit;
    }


    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        SolutionRecursive solution = new SolutionRecursive();
        int bestProfit = solution.maxProfit(prices);

        System.out.println("\n#"+bestProfit);
    }
}
