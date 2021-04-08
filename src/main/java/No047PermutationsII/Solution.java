package No047PermutationsII;
/*
Medium

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> pmtList = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();  // Decision space:  store nums left
        Arrays.sort(nums);
        for(int i : nums)
        {
            numsList.add(i);
        }

        buildPermute(resList, pmtList, numsList);
        return resList;
    }

    private void buildPermute(List<List<Integer>> resList, List<Integer> pmtList, List<Integer> numsList)
    {
        //base case
        if( numsList.size() == 0)
        {
            resList.add(pmtList);
            return;
        }

        for(int i=0; i < numsList.size(); i++)
        {
            if( i > 0 && numsList.get(i) == numsList.get(i-1))
                continue; // skip duplicates
            List<Integer> newPmtList= new ArrayList<Integer>(pmtList);
            newPmtList.add(numsList.get(i));
            List<Integer> newNumsList= new ArrayList<Integer>(numsList);
            newNumsList.remove(i);
            buildPermute(resList, newPmtList, newNumsList);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<List<Integer>> lists = solution.permute(new int[]{1,2,3,4});
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1,1,1});
        for (List<Integer> one : lists) {
            System.out.println(one);
        }
    }
}
