package book.sword_offer;

// 问题多
public class No032NumberOf1Between1AndN {

    public int numberOf1Between1AndN_plain(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i ++) {
            ans += numberOf1Plain(i);
        }
        return ans;
    }
    int numberOf1Plain(int n) {
        int number = 0;
        while(n != 0) {
            if (n % 10 == 1) {
                number ++;
            }
            n = n / 10;
        }
        return number;
    }

    public int numberOf1Between1AndN(int n) {
        if (n < 0)
            return 0;
        String strN = n + "";
        return numberOf1(strN);
    }

    int numberOf1(String strN) {
        int firstNum = strN.charAt(0) - '0';

        if (strN.length() == 1 && firstNum == 0) {
            return 0;
        }

        if (strN.length() == 1 && firstNum > 0) {
            return 1;
        }

        int numFirstDigit = 0;

        if (firstNum > 1) {
            numFirstDigit = (int)Math.pow(10, strN.length() - 1);
        } else {
            numFirstDigit = Integer.parseInt(strN.substring(1)) + 1;
        }

        int numOtherDigit = firstNum * (strN.length() - 1) * (int)Math.pow(10, strN.length() - 2);


        int numRecursive = numberOf1(strN.substring(1));
        return numFirstDigit + numOtherDigit + numRecursive;
    }

    public static void main(String[] args) {
        No032NumberOf1Between1AndN solution = new No032NumberOf1Between1AndN();
//        int ans = solution.numberOf1Between1AndN(10000);  // 21345:18821
        int ans = solution.numberOf1Between1AndN_plain(999); // 21345:18820
//        int ans = solution.numberOf1Between1AndN(151);
        System.out.println(ans);
    }
}
