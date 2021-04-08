package resolved.No459RepeatedSubstringPattern;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
//        if (s.length() % 2 == 1) {
//            return false;
//        }

        for (int j = 0; j < s.length() / 2; j++) {
            int endPosition = -1;
            boolean result = true;
            for (int i = j + 1; i < s.length(); i ++) {
                if (endPosition == -1) {
                    if (s.charAt(i) == s.charAt(0)) {
                        i--;
                        endPosition = i;
                    }
                } else {
                    if ((s.length() % (endPosition + 1) != 0)
                            || (s.charAt(i % (endPosition + 1)) != s.charAt(i))) {
                        result = false;
                        break;
                    }
                }
            }
            if (result != false && endPosition != -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "abcabcabcabc";
//        String s = "abaababaab";
//        String s = "abac";
        String s = "aaa";
//        String s = "ab";
        Boolean isRepeat = solution.repeatedSubstringPattern(s);
        System.out.println(isRepeat);
    }
}
