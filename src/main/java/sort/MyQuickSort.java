package sort;

public class MyQuickSort {

//    public static void qSort(int[] arr, int head, int tail) {
//        if (head >= tail || arr == null || arr.length <= 1) {
//            return;
//        }
//        int mid = (tail + head)/2;
//        int i = head, j = tail;
//        while (i <= j) {
//            while (arr[i] < arr[mid]) {
//                i ++;
//            }
//            while (arr[mid] < arr[j]) {
//                j --;
//            }
//            if (i < j) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                i ++;
//                j --;
//            } else {
//                i ++;
//            }
//            System.out.println(head + "\t" + j  + "\t" +  mid);
//            qSort(arr, head, j);
//            qSort(arr, i, tail);
//
//        }
//    }

    public static void qSort2(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length<=1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while(i < j) {
            while (arr[i] < pivot) {
                i ++;
            }
            while (arr[j] > pivot) {
                j --;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i ++;
                j --;
            } else {
                i ++;
            }
        }

        qSort2(arr, head, j);
        qSort2(arr, i, tail);
    }

    public static void main(String[] args) {
        System.out.println("23");
        int[] arr = new int[]{6,4,3,1,2,5,7,5};
        qSort2(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
