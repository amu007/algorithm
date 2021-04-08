package fib;

public class SolutionRecursive {

    public int[] cache = null;

    public int fib(int n) {
        if (cache == null) {
            cache = new int[n + 1];
        }

        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i <= n; i ++) {
            cache[i] = cache[i-1] + cache[i - 2];
        }

        return cache[n];
    }

    public static void main(String[] args) {
        SolutionRecursive solution = new SolutionRecursive();
        int result = solution.fib(6);
        System.out.println(result + "");
    }
}
