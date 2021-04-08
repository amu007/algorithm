package No014LongestCommonPrefix;

import javax.xml.bind.SchemaOutputResolver;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        return helper(strs, "", 0);
    }

    public String helper(String[] strs, String prefix, int index) {
        Character commonWord = null;
        for (int i = 0; i < strs.length; i ++) {
            if (strs[i].length() > index) {
                if (i == 0) {
                    commonWord = strs[0].charAt(index);
                } else {
                    if (strs[i].charAt(index) != commonWord) {
                        return prefix;
                    }
                }
            } else {
                return prefix;
            }
        }
        prefix += commonWord;
        prefix = helper(strs, prefix, index + 1);
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"hello1", "1he", "hell"};

        Solution solution = new Solution();
        String longestCommonPrefix = solution.longestCommonPrefix(strs);
        System.out.println("DONE");
        System.out.println(longestCommonPrefix);
    }
}
