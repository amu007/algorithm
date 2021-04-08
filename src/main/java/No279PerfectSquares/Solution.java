package No279PerfectSquares;

import java.util.ArrayList;
import java.util.List;

/*

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.


TODO 类似于整钱化零的问题。待学习 2018/11/30 16:16
* */
public class Solution {
//    public int numSquares(int n) {
//        List<Integer> squareNums = new ArrayList<>();
//        for (int i = 1; i <=n; i ++) {
//            if(helper(i, 0, i)) squareNums.add(i);
//        }
//        System.out.println(squareNums);
//
//
//        return 1;
//    }
//
//    public boolean helper(int num, int start, int end) {
//        if (start > end) {
//            return false;
//        }
////        float devide = (start + end) / 2F;
//        int devide = (start + end)/2;
//
//        float num2 = num / (float)devide;
//
//        if (num2 == devide) {
//            return true;
//        } else if (num2 > devide) {
//            return helper(num, (int)devide + 1, end);
//        } else if (num2 < devide) {
//            return helper(num, start, (int)devide - 1);
//        }
//        return false;
//    }

    public int numSquares(int n) {
        List<Integer> squareNums = new ArrayList<>();
        for (int i = 1; i <=n; i ++) {
            if (i * i == n) {
                return 1;
            } else if (i * i < n) {
                squareNums.add(i * i);
            } else if (i * i > n) {
                break;
            }
        }
        System.out.println(squareNums);


        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = solution.numSquares(101);
        System.out.println(n);
    }
}
