package resolved.No120Triangle;

import java.util.Arrays;
import java.util.List;

public class SolutionRecursive {
//    Works1;
//    public Integer[][] cache = null;
//
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle.size() == 1) {
//            return triangle.get(0).get(0);
//        }
//
//        cache = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            for (int j = 0; j < triangle.get(i).size() - 1; j ++) {
//                if (cache[i][j] == null) {
//                    cache[i][j] = triangle.get(i).get(j);
//                }
//                if (cache[i][j+1] == null) {
//                    cache[i][j+1] = triangle.get(i).get(j + 1);
//                }
//                int result = (cache[i][j] < cache[i][j+1] ? cache[i][j] : cache[i][j+1]) + triangle.get(i - 1).get(j);
//                cache[i - 1][j] = result;
//
//            }
//        }
//
//        return cache[0][0];
//    }

//    Works2;
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle.size() == 1) {
//            return triangle.get(0).get(0);
//        }
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            for (int j = 0; j < triangle.get(i).size() - 1; j ++) {
//                int left = triangle.get(i).get(j); int right = triangle.get(i).get(j + 1);
//                triangle.get(i - 1).set(j, (left < right ? left : right) + triangle.get(i - 1).get(j));
//            }
//        }
//
//        return triangle.get(0).get(0);
//    }

// works3
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                int left = triangle.get(i + 1).get(j); int right = triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, (left < right ? left : right) + triangle.get(i).get(j));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<Integer> l0 = Arrays.asList(2);
        List<Integer> l1 = Arrays.asList(3,4);
        List<Integer> l2 = Arrays.asList(6,5,7);
        List<Integer> l3 = Arrays.asList(4,1,8,3);

        List<List<Integer>> triangle = Arrays.asList(l0, l1, l2, l3);
//        List<List<Integer>> triangle = Arrays.asList(l0);
        System.out.println(triangle);

        SolutionRecursive solutionRecursion = new SolutionRecursive();
        int result = solutionRecursion.minimumTotal(triangle);
        System.out.println(result + "");
    }
}
