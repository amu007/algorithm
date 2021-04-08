package aws02;

public class MyBigInt {

    public String sum(String s1, String s2) {
        int len1 = s1.length() - 1, len2 = s2.length() - 1, add = 0;
        String sumStr = "";
        while (len1 >= 0 && len2 >= 0) {
            int i1 = new Integer(s1.charAt(len1)+"");
            int i2 = new Integer(s2.charAt(len2)+"");
            int sum = i1 + i2 + add;
            add = sum / 10;
            sumStr = (sum % 10) + sumStr;
            len1 --;
            len2 --;
        }
        while (len1 >= 0) {
            int i1 = new Integer(s1.charAt(len1)+"");
            int sum = i1 + add;
            add = sum / 10;
            sumStr = (sum % 10) + sumStr;
            len1 --;
        }
        while (len2 >= 0) {
            int i2 = new Integer(s2.charAt(len2)+"");
            int sum = i2 + add;
            add = sum / 10;
            sumStr = (sum % 10) + sumStr;
            len2 --;
        }

        if (add != 0) {
            sumStr = add + sumStr;
        }

        return sumStr;
    }

    public static void main(String[] args) {

        String s1 = "1";
        String s2 = "9999";

        MyBigInt myBigInt = new MyBigInt();
        String sum = myBigInt.sum(s1, s2);
        System.out.println(sum);

    }
}
