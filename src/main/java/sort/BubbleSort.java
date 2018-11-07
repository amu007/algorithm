package sort;

public class BubbleSort {

    public static void bSort(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr.length - 1; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("23");
//        int[] arr = new int[]{1,4,3,2,5};
        int[] arr = new int[]{6,4,3,1,2,5,0};
        bSort(arr);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
