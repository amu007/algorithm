package resolved.No022GenerateParentheses;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SolutionHorizontalScanning {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, n, n, "");
        return list;
    }

    public void generate(List<String> list, int left, int right, String str) {
        if (left == 0 && right == 0) {
            list.add(str);
        }

        if (left >= 0) {
            generate(list, left - 1, right, str+"(");
        }
        if (right >= 0 && right > left) {
            generate(list, left, right - 1, str+")");
        }
    }

    public static void main(String[] args) {
        SolutionHorizontalScanning solution = new SolutionHorizontalScanning();
        List<String> list = solution.generateParenthesis(1);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
