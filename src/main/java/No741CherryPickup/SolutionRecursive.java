package No741CherryPickup;

import java.util.Arrays;

public class SolutionRecursive {

    public int cherryPickup(int[][] grid) {
        int result = 0;
        int[][] dp = helper(grid);
        if (dp[0][0] == 0) {
            return 0;
        } else {
            if (!clearPath(grid, dp) ) {
                return 0;
            }
            result += dp[0][0];
            dp = helper(grid);
            result += dp[0][0];

        }

        return result;
    }
    private boolean clearPath(int[][] grid, int[][] dp) {
        int N = grid.length - 1;
        int i = 0;
        int j = 0;
        do {
            grid[i][j] = 0;
            if (dp[i][j] == 0) {
                return false;
            }
            if (i >= N) {
                j ++;
            } else if (j >= N) {
                i ++;
            } else {

                if (dp[i + 1][j] + 1 >= dp[i][j + 1] + 1) {
                    i ++;
                } else {
                    j ++;
                }
            }
        } while (i < N || j < N);
        grid[N][N]=0;
        return true;
    }


    private int[][] helper(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];
        dp[N - 1][N - 1] = grid[N - 1][N - 1];

        for (int i = N - 1; i >= 0; i --) {
            for (int j = N - 1; j >= 0; j --) {
                if (grid[i][j] >= 0 && (i != N-1 || j != N-1)) {
                    if (i + 1 == N) {
                        dp[i][j] = Math.max(grid[i][j] + dp[i][j + 1], Integer.MIN_VALUE);
                    } else if (j + 1 == N) {
                        dp[i][j] = Math.max(grid[i][j] + dp[i + 1][j], Integer.MIN_VALUE);
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                    }
                }
            }
        }

        return dp;
    }


//rivate boolean clearPath(int[][] grid, int[][] dp) {
//        int N = grid.length - 1;
//        int i = 0;
//        int j = 0;
//        do {
//            grid[i][j] = 0;
//            if (dp[i][j] == 0) {
//                return false;
//            }
//            if (dp[i][j] == dp[i][j + 1] + 1) {
//                if (j != N) {
//                    j ++;
//                } else {
//                    i ++;
//                }
//            } else {
//                if (i != N) {
//                    i ++;
//                } else {
//                    j ++;
//                }
//            }
//
//        } while (i < N || j < N);
//        grid[N][N]=0;
//        return true;
//    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]
//        {
//                {0, 1, -1},
//                {1, 0, -1},
//                {1, 1,  1}
//        };

//        int[][] grid = new int[][]
//                {
//                        {1, 1, 1, 0, 0},
//                        {0, 0, 1, 0, 1},
//                        {1, 0, 1, 0, 0},
//                        {0, 1, 1, 0, 0},
//                        {0, 0, 1, 1, 1}
//                };

//        int[][] grid = new int[][]
//                {
//                        {1, 1, -1},
//                        {1, -1, 1},
//                        {-1, 1, 1}
//                };

//
//        int[][] grid = new int[][]
//                {
//                        {0, 1, -1},
//                        {1, 0, -1},
//                        {1, 1, 1}
//                };
        int[][] grid = new int[][]
                {
                        {1,1,1,1,0,0,0},
                        {0,0,0,1,0,0,0},
                        {0,0,0,1,0,0,1},
                        {1,0,0,1,0,0,0},
                        {0,0,0,1,0,0,0},
                        {0,0,0,1,0,0,0},
                        {0,0,0,1,1,1,1}
                };


        SolutionRecursive solution = new SolutionRecursive();
        int i = solution.cherryPickup(grid);
        System.out.println(i);
    }
}
