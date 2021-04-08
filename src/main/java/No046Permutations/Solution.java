package No046Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
*
Medium

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
* */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            List<Integer> numsList = new ArrayList<>();
            numsList.add(nums[i]);
            all = helper(all, nums[i]);
        }
        return all;
    }

    public List<List<Integer>> helper(List<List<Integer>> list, int num) {
        List<List<Integer>> all = new ArrayList<>();
        if (list == null || list.size() == 0) {
            List<Integer> newOne = new ArrayList<>();
            newOne.add(num);
            all.add(newOne);
        } else {
            for (int i = 0; i < list.size(); i++) {
                int rowSize = list.get(0).size();
                for (int j = 0; j <= rowSize; j++) {
                    List<Integer> newOne = new ArrayList<>(list.get(i));
                    newOne.add(j, num);
                    all.add(newOne);
                }
            }
        }
        return all;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<List<Integer>> lists = solution.permute(new int[]{1,2,3,4});
        List<List<Integer>> lists = solution.permute(new int[]{1,1,2,2});
        for (List<Integer> one : lists) {
            System.out.println(one);
        }
    }
}
