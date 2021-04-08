package ali;

public class Bag1 {
    public static int solution(int[][] goods, int w) {
        int dp[] = new int[w+1];

        for (int i = 1; i < w + 1; i ++) {
            for (int j = 0; j < goods.length; j ++) {
                if (i - goods[j][0] >= 0
                        && dp[i] < dp[i - goods[j][0]] + goods[j][1]) {
                    dp[i] = dp[i - goods[j][0]] + goods[j][1];
                }
            }
        }

        return dp[w];
    }

    public static void main(String[] args) {
        int[][] goods = {{2,3},{1,1},{3,4},{2,2}};
        int w = 5;

        int v = solution(goods, w);
        System.out.println("v:" + v);
    }
}
