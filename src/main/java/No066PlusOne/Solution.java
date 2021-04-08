package No066PlusOne;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAP12Binding;

public class Solution {
    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            int data = digits[i] + plus;
            plus = data / 10;
            digits[i] = data % 10;
        }
        if (plus != 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = plus;
            for (int i = 0; i < digits.length; i ++) {
                newDigits[i + 1] = digits[i];
            }
            digits = newDigits;
        }

        return digits;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = solution.plusOne(new int[]{9});
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
    }
}
