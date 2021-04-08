package resolved.No120Triangle;

import java.util.Arrays;
import java.util.List;

public class SolutionRecursionDP {

//    public int minimumTotal(List<List<Integer>> triangle) {
//        return helper(triangle, 0, 0);
//    }
//    private int helper(List<List<Integer>> triangle, int i, int j) {
//        System.out.println(i);
//
//        if (i == triangle.size() - 1) {
//            return triangle.get(i).get(j);
//        }
//        int left = helper(triangle, i + 1, j);
//        int right = helper(triangle, i + 1, j + 1);
//
//        left = left < right ? left : right;
//        return left + triangle.get(i).get(j);
//    }

    public Integer[][] cache = null;

    public int minimumTotal(List<List<Integer>> triangle) {
        cache = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return helper(triangle, 0, 0);
    }
    private int helper(List<List<Integer>> triangle, int i, int j) {
        if (cache[i][j] != null) {
            System.out.println(i +"\t"+ j);
            return cache[i][j];
        }
        int result = 0;
        if (i == triangle.size() - 1) {
            result = triangle.get(i).get(j);
        } else {
            int left = helper(triangle, i + 1, j);
            int right = helper(triangle, i + 1, j + 1);

            result = (left < right ? left : right) + triangle.get(i).get(j);
        }
        cache[i][j] = result;
        return cache[i][j];
    }


    public static void main(String[] args) {
        List<Integer> l0 = Arrays.asList(2);
        List<Integer> l1 = Arrays.asList(3,4);
        List<Integer> l2 = Arrays.asList(6,5,7);
        List<Integer> l3 = Arrays.asList(4,1,8,3);

        List<List<Integer>> triangle = Arrays.asList(l0, l1, l2, l3);
        System.out.println(triangle);

        SolutionRecursionDP solutionRecursion = new SolutionRecursionDP();
        int result = solutionRecursion.minimumTotal(triangle);
        System.out.println(result + "");
    }
}
