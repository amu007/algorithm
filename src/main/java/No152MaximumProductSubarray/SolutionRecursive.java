package No152MaximumProductSubarray;

public class SolutionRecursive {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int positiveTemp = nums[0];
        int min = nums[0];
        int negitiveTemp = nums[0] < 0 ? nums[0] * -1 : nums[0];
        int negetive = negitiveTemp < 0 ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            positiveTemp = positiveTemp * nums[i];
            positiveTemp = nums[i] > positiveTemp ? nums[i] : positiveTemp;
            max = positiveTemp > max ? positiveTemp : max;

            int temp = nums[i];
            if (temp < 0) {
                negetive ++;
                temp *= -1;
            }
            negitiveTemp = negitiveTemp * temp;
            negitiveTemp = temp > negitiveTemp ? temp : negitiveTemp;
            min = negitiveTemp > min ? negitiveTemp : min;
        }
        if (negetive%2==1) {
            min *= -1;
        }
        
        return max > min? max : min;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,-2,4};
//        int[] nums = new int[]{2,3,0,-2,4,-200};
//        int[] nums = new int[]{-2};
//        int[] nums = new int[]{-2,0,-1};
//        int[] nums = new int[]{0};
//        int[] nums = new int[]{-2,3,-4};
//
//        SolutionRecursive solutionRecursionDP = new SolutionRecursive();
//        int result = solutionRecursionDP.maxProduct(nums);
//        System.out.println(result);
    }
}
