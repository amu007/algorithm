package sort;

public class BubbleSort {

    public static void bSort(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr.length - i - 1; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int i, temp, len = arr.length;
        boolean changed;
        do {
            changed = false;
            len-=1;
            for (i = 0; i < len; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    changed = true;
                }
            }
        } while (changed);
    }

    public static void main(String[] args) {
        System.out.println("23");
//        int[] arr = new int[]{1,4,3,2,5};
        int[] arr = new int[]{6,4,3,1,2,5,0};
        bSort(arr);
//        bubbleSort(arr);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
