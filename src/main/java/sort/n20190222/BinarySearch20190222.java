package sort.n20190222;

public class BinarySearch20190222 {

    public static int searchRecursion(int[] arr, int num, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (num == arr[mid]) {
            return mid;
        } else if (num < arr[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return searchRecursion(arr, num, start, end);
    }

    public static int searchWhile(int[] arr, int num, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num == arr[mid]) {
                return mid;
            } else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int s = searchWhile(arr, 8, 0, arr.length - 1);
        System.out.println(s);
    }
}
