package fib;

public class SolutionRecursive2 {

    public int fib(int n) {
        if (n <= 1) {
            return 1;
        }

        int first = 1;
        int second = 1;

        for (int i = 2; i <= n; i ++) {
            first = first + second;
            second = first - second;
        }

        return first;
    }

    public static void main(String[] args) {
        SolutionRecursive2 solution = new SolutionRecursive2();
        int result = solution.fib(9);
        System.out.println(result + "");
    }
}
