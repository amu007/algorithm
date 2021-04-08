package resolved.No459RepeatedSubstringPattern;

public class SolutionFromLeetCode {
    public boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    public static void main(String[] args) {
        SolutionFromLeetCode solution = new SolutionFromLeetCode();
//        String s = "abcabcabcabc";
//        String s = "abaababaab";
        String s = "abac";
//        String s = "aaa";
//        String s = "ababab";
        Boolean isRepeat = solution.repeatedSubstringPattern(s);
        System.out.println(isRepeat);
    }
}
