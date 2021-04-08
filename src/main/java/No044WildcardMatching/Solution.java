package No044WildcardMatching;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorCompletionService;

public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    public boolean helper(String s, String p, int si, int pi) {
        if (si >= s.length() || pi >= p.length()) {
            return false;
        }

        if (si == s.length() - 1 && pi == p.length() - 1) {
            return (s.charAt(si) == p.charAt(pi)) || '?' == p.charAt(pi) || '*' == p.charAt(pi);
        }

        boolean result = false;
        char pc = p.charAt(pi);
        if (s.charAt(si) == pc || '?' == pc) {
            return helper(s, p, si + 1, pi + 1);
        } else if ('*' == pc) {
            if (pi >= p.length() - 1) {
                return true;
            } else if (pi >= p.length() - 2) {
                return helper(s, p, s.length() - 1, pi + 1);
            } else {
                char pc_next = p.charAt(pi + 1);
                if (s.charAt(si) == pc_next) {
                    return helper(s, p, si + 1, pi + 2);
                } else {
                    return helper(s, p, si + 1, pi);
                }
            }
        }

        return result;
    }

//    public boolean helper(String s, String p, int si, int pi) {
//        if (si >= s.length() || pi >= p.length()) {
//            return false;
//        }
//
//        if (si == s.length() - 1 && pi == p.length() - 1) {
//            return (s.charAt(si) == p.charAt(pi)) || '?' == p.charAt(pi) || '*' == p.charAt(pi);
//        }
//
//        boolean result = false;
//        char pc = p.charAt(pi);
//        if (s.charAt(si) == pc || '?' == pc) {
//            return helper(s, p, si + 1, pi + 1);
//        } else if ('*' == pc) {
//            if (pi >= p.length() - 1) {
//                return true;
//            } else if (pi >= p.length() - 2) {
//                return helper(s, p, s.length() - 1, pi + 1);
//            } else {
//                char pc_next = p.charAt(pi + 1);
//                if (s.charAt(si) == pc_next) {
//                    return helper(s, p, si + 1, pi + 2);
//                } else {
//                    return helper(s, p, si + 1, pi);
//                }
//            }
//        }
//
//        return result;
//    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Boolean result = null;
/*
        result = solution.isMatch("amu", "amu");
        Assertions.assertEquals(true, result);

        result = solution.isMatch("amu", "a*");
        Assertions.assertEquals(true, result);

        result = solution.isMatch("amu1", "amu");
        Assertions.assertEquals(false, result);

        result = solution.isMatch("amu", "?mu");
        Assertions.assertEquals(true, result);

        result = solution.isMatch("amu1", "?mu");
        Assertions.assertEquals(false, result);

        result = solution.isMatch("aa", "a");
        Assertions.assertEquals(false, result);

        result = solution.isMatch("aa", "*");
        Assertions.assertEquals(true, result);

        result = solution.isMatch("cb", "?a");
        Assertions.assertEquals(false, result);

        result = solution.isMatch("adceb", "*a*b");
        Assertions.assertEquals(true, result);

        result = solution.isMatch("acdcb", "a*c?b");
        Assertions.assertEquals(false, result);

        result = solution.isMatch("aa", "a*");
        Assertions.assertEquals(true, result);

        result = solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de");
        Assertions.assertEquals(true, result);
 */
        result = solution.isMatch("dadcde", "*de");
        Assertions.assertEquals(true, result);
    }
}
