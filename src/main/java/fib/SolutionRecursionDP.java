package fib;

public class SolutionRecursionDP {

    public int[] cache = null;

    public int fib(int n) {
        if (cache == null) {
            cache = new int[n + 1];
        }
        if (n <= 1) {
            return 1;
        }

        if (cache[n] == 0) {
            cache[n] = fib(n - 1) + fib(n - 2);
        }

        return cache[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++) {
            SolutionRecursionDP solution = new SolutionRecursionDP();
            int result = solution.fib(i);
            System.out.println(i + "\t" + result);
        }
    }
}
