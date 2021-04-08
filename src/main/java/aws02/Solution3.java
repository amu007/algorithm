package aws02;

import java.util.ArrayList;
import java.util.List;

// Closure Number
public class Solution3 {
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        List<String> ans = solution.generateParenthesis(3);
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
