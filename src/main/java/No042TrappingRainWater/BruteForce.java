package No042TrappingRainWater;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;

public class BruteForce {
    public int trap(int[] height) {
        int len = height.length;
        int ans = 0;
        for(int i = 1; i < len - 1; i ++) {
            int max_left = 0, max_right = 0;
//            for (int j = i; i >=0; j --) {
//                max_left = Math.max(max_left, height[j]);
//            }
//
//            for (int j = len - 1; j > i; j ++) {
//                max_right = Math.max(max_right, height[j]);
//            }
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < len; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }

        return ans;
    }

    @Test
    public void foo() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        BruteForce bruteForce = new BruteForce();
        int ans = bruteForce.trap(height);
        Assertions.assertEquals(-1, ans);
    }
}
