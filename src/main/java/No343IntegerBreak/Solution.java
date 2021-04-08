package No343IntegerBreak;

/**
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class Solution {
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int i = n/3;
        while (i > 0) {
            System.out.println("#"+i);
            if (n%(3 * i) == 0) {
                return (int)Math.pow(3, i);
            } else if(((n-(3 * i)))%2 == 0) {
                return (int)(Math.pow(3, i) * Math.pow(2, (n-(3 * i))/2));
            } else {
                i --;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(Math.pow(3,4)+"");
        Solution solution = new Solution();
        int result = solution.integerBreak(173);
        System.out.println(result);
    }

}
