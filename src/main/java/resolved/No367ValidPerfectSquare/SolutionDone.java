package resolved.No367ValidPerfectSquare;

/*
*
* DONE 2018-11-30 16:03
* */
public class SolutionDone {
    public boolean isPerfectSquare(int num) {
        return helper(num, 0, num);
    }

    public boolean helper(int num, int start, int end) {
        if (start > end) {
            return false;
        }
//        float devide = (start + end) / 2F;
        int devide = (start + end)/2;

        float num2 = num / (float)devide;

        if (num2 == devide) {
            return true;
        } else if (num2 > devide) {
            return helper(num, (int)devide + 1, end);
        } else if (num2 < devide) {
            return helper(num, start, (int)devide - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        SolutionDone solution = new SolutionDone();
//        boolean result = solution.isPerfectSquare(2147483647);
//        System.out.println("->" +result);

        for (int i = 0; i < 37; i ++) {
            boolean result = solution.isPerfectSquare(i);
            System.out.println(i + "->" +result);
        }
    }
}
