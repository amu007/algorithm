package aws02;

import java.math.BigInteger;

public class Kuaishou01 {
//    public void solve(int[] arr) {
//        int i = 1, j = 1, n = arr.length;
//
//        boolean flag = arr[0] > 0;
//
//        while (i < n && j < n) {
//            if (!flag) {
//                if (arr[j] > 0) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                    i ++;
//                    j = i;
//                    flag = !flag;
//                } else {
//                    j ++;
//                }
//            }
//            if (flag) {
//                if (arr[j] < 0) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                    i ++;
//                    j = i;
//                    flag = !flag;
//                } else {
//                    j ++;
//                }
//            }
//        }
//    }
    public void solve(int[] arr) {
        int i = 1, j = 1, n = arr.length;

        boolean flag = arr[0] > 0;

        while (j < n) {
            if ((!flag && arr[j] > 0) || (flag && arr[j] < 0)) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i ++;
                    j = i;
                    flag = !flag;
                } else {
                    j ++;
                }
            }
    }


    public static void main(String[] args) {
        System.out.println("2");
        Kuaishou01 kuaishou01 = new Kuaishou01();
//        int[] nums = new int[]{1,2,3,4,-1,-2,-3,-5,5,6,7};
//        int[] nums = new int[]{1,2,-1,-2};
//        int[] nums = new int[]{-1,-2,1,2};
//        int[] nums = new int[]{-1,1,-2,2};
        int[] nums = new int[]{-1,-2,-3,2};
        kuaishou01.solve(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}
