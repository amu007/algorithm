package kmp;

/**
 * https://blog.csdn.net/christ1750/article/details/51259425
 */
public class KMP {
    public static int kmp(String str, String dest,int[] next){//str文本串  dest 模式串
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
            }
        }
        return 0;
    }
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public static void main(String[] args){
        String b = "ssdfgasdbababa";
//        String a = "ababa";
        String a = "ababac";
        int[] next = kmpnext(a);
        int res = kmp(b, a,next);
        System.out.println(res);

        for(int i = 0; i < next.length; i++){
            System.out.print(next[i] + "\t");
        }
        System.out.println();
        System.out.println(next.length);
    }
}
