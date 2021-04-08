package aws02;

public class CutString {
    public int solution(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;


        for (int i = 4; i <= n; i ++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j ++) {
                int product = dp[j] * dp[i - j];
                max = Math.max(max, product);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CutString c = new CutString();
        int ans = c.solution(5);
        System.out.println(ans);
    }

}
