package resolved.No093RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        for (int p1 = 1; p1 <= 3; p1 ++) {
            for (int p2 = 1; p2 <= 3; p2 ++) {
                for (int p3 = 1; p3 <= 3; p3 ++) {
                    for (int p4 = 1; p4 <= 3; p4 ++) {
                        String res = helper(s, p1, p2, p3, p4);
                        if (res != null) {
                            ans.add(res);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public String helper(String s, int p1, int p2, int p3, int p4) {
        if ((p1 + p2 + p3 + p4) == s.length()) {
            String s1 = s.substring(0, p1);
            String s2 = s.substring(p1,  p1 + p2);
            String s3 = s.substring(p1 + p2, p1 + p2 + p3);
            String s4 = s.substring(p1 + p2 + p3, p1 + p2 + p3 + p4);

            if (valid(s1) && valid(s2) && valid(s3) && valid(s4)) {
                return s1 + "." + s2 + "." + s3 + "." + s4;
            }
            return null;
        }
        return null;
    }

    public boolean valid(String s) {
        return (Integer.parseInt(s) <= 255 &&
                (s.length() == 1 || (s.length() != 1 && s.charAt(0) != '0')));
    }

    public static void main(String[] args) {
//        String input = "25525511135";
        String input = "010010";
//        Output: ["255.255.11.135", "255.255.111.35"]
        Solution solution = new Solution();
        System.out.println(solution.valid("1"));
        List<String> ans = solution.restoreIpAddresses(input);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }

//        "010010"
//        ["0.1.0.010","0.1.00.10","0.1.001.0","0.10.0.10","0.10.01.0","0.100.1.0","01.0.0.10","01.0.01.0","01.00.1.0","010.0.1.0"]
//        ["0.10.0.10","0.100.1.0"]
//        System.out.println("25525511135".substring(1,2));
    }

}
