package No121BestTimeToBuyAndSellStock;

public class SolutionRecursion {
    public int maxProfit(int[] prices) {
        int bestProfit = 0;

        if (prices.length == 1) {
            return bestProfit;
        }

        bestProfit = Math.max(bestProfit, helper(prices, 1));

        return bestProfit;
    }

    public int helper(int[] prices, int index) {
        int max = 0;
        if (index >= prices.length) {
            return max;
        }
        for (int i = 0; i < index; i ++) {
            if (prices[index] > prices[i]) {
                max = Math.max(max, prices[index] - prices[i]);
            }
        }
        return Math.max(max, helper(prices, index + 1));
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        SolutionRecursion solution = new SolutionRecursion();
        int bestProfit = solution.maxProfit(prices);
        System.out.println(bestProfit);
    }
}
