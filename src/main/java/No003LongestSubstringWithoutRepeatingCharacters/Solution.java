package No003LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        int length = 1;
        int[] letters = new int[128];

        letters[s.charAt(0)] = 1;

        for (int i = 0, j = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(letters[c] == 0) {
                length ++;
                letters[c] = length;
            } else {
                length = Math.max(length, letters[c]);
//                letters[c] =
            }
        }

        int max = 0;
        for (int i = 0; i < letters.length; i++) {
            max = max > letters[i] ? max : letters[i];
        }

        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abcabcbb";
        int i = 0;

//        i = solution.lengthOfLongestSubstring(s);
//        System.out.println(i);
//
//        s = "bbbbbb";
//        i = solution.lengthOfLongestSubstring(s);
//        System.out.println(i);
//
        s = "pwwkewa";
        i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);

        s = "ckilbkd";
        i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
