package sort.n20190225;

public class QuickSort20190225 {
    public static void qSort2 (int[] arr, int begin, int end) {
        if (begin > end) {
            return;
        }
        int pivot = arr[(begin + end) / 2];
        int i = begin;
        int j = end;
        while(i <= j) {
            while(arr[i] < pivot) {
                i ++;
            }
            while(arr[j] > pivot) {
                j --;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i ++;
                j --;
            } else {
                i ++;
            }
        }
        qSort2(arr, begin, j);
        qSort2(arr, i, end);
    }

    public static void main(String[] args) {
        System.out.println("23");
        int[] arr = new int[]{6,4,7,3,1,2,5};
        qSort2(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
