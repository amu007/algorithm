package book.sword_offer;

public class No012print1ToMaxOfNDigits {
    public static void printInt(int N) {
        char[] nums = new char[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = '0';
        }

        while (!increment(nums)) {
            printNum(nums);
        }

    }

    public static boolean increment(char[] nums) {
        boolean isOverflow = false;
        int nTakeover = 0;
        int nLength = nums.length;

        for (int i = nLength - 1; i >= 0; i --) {
            int nsum = nums[i] - '0' + nTakeover;
            if (i == nLength - 1) {
                nsum ++;
            }

            if (nsum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nsum -= 10;
                    nTakeover = 1;
                    nums[i] = (char) ('0' + nsum);
                }
            } else {
                nums[i] = (char) ('0' + nsum);
                break;
            }
        }
        return isOverflow;
    }

    public static void printNum(char[] nums) {
        boolean isPrint = true;
        for (int i = 0; i < nums.length; i++) {
            if (isPrint && nums[i] != '0') {
                isPrint = false;
            }
            if (!isPrint) {
                System.out.print(nums[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printInt(3);
    }

}
