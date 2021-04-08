package sort.n20190225;

public class MergeSort20190225 {

    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end || arr == null || arr.length == 0) {
            return;
        }
        int mid = (start + end) / 2;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);

        int k = start;
        while(start1 <= end1 && start2 <= end2) {
            result[k ++] = arr[start1] < arr[start2] ? arr[start1 ++] : arr[start2 ++];
        }

        while(start1 <= end1) {
            result[k ++] = arr[start1 ++];
        }

        while(start2 <= end2) {
            result[k ++] = arr[start2 ++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,4,7,3,1,2,5};

        int[] result = new int[arr.length];

        merge_sort_recursive(arr, result, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
