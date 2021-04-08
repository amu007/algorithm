package fib;

public class Solution {

    public int fib(int n) {
        if (n <= 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.fib(6);
        System.out.println(result + "");
    }
}
