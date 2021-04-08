package sort;

public class MyMergeSort {
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = start - end;
        int mid = (start + end) / 2;

        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k ++] = arr[start1] < arr[start2] ? arr[start1 ++] : arr[start2 ++];
        }
        while (start1 <= end1) {
            result[k ++] = arr[start1 ++];
        }
        while (start2 <= end2) {
            result[k ++] = arr[start2 ++];
        }

        for (int i = start; i <= end; i ++) {
            arr[i] = result[i];
        }
    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }

    public static void main(String[] args) {
//        MergeSortFromWikipedia.merge_sort();
        int[] arr = new int[]{1,4,3,2,5};
        merge_sort(arr);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
