package kmp;

/**
 * https://time.geekbang.org/column/article/71845
 */
public class KmpGeekBang {

    public static void main(String[] args) {
        KmpGeekBang kmp = new KmpGeekBang();
        String b = "ssdfgasdbababad";
        String a = "ababa";
//        String b = "ababababe";
//        String a = "abaaba";
//        String a = "abac";

//        String a = "abaabc";
        int position = kmp.kmp(b.toCharArray(), b.length(), a.toCharArray(), a.length());
        System.out.println("position:" + position);
    }

    // a, b 分别是主串和模式串；n, m 分别是主串和模式串的长度。
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        for (int i = 0; i < next.length; i++) {
            System.out.print("\t" + next[i]);
        }
        System.out.println();
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // 一直找到 a[i] 和 b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }

    // b 表示模式串，m 表示模式串的长度
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

}
