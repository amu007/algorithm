package resolved.No174DungeonGame;

public class SolutionRecursive {

/*

if d[i] 为正 且 d[i + 1]为正，then dp[i]=0
if d[i] 为正 且 d[i + 1]为负，then dp[i] = d[i + 1] + d[i] 为负数
if d[i] 为负 且 d[i + 1]为负，then dp[i] = d[i + 1] + d[i] 为负数
if d[i] 为负 且 d[i + 1]为正，then dp[i] = d[i] 不需要变化

*/
//    public void helper(int[][] dungeon, int x, int y, int x1, int y1) {
//        if (dungeon[x][y] >= 0 && dungeon[x1][y1] >= 0) {
//            dungeon[x][y] = 0;
//        }
////        if (dungeon[x][y] >= 0 && dungeon[x1][y1] < 0) {
////            dungeon[x][y] = dungeon[x][y];
////        }
//        if (dungeon[x1][y1] < 0 ) {
//            dungeon[x][y] = dungeon[x][y] + dungeon[x1][y1];
//            if (dungeon[x][y] >= 0) {
//                dungeon[x][y] = 0;
//            }
//        }
//    }
//
//    public int calculateMinimumHP(int[][] dungeon) {
//        int row = dungeon.length, col = dungeon[0].length;
//
//        for (int i = col - 2; i >= 0; i --) {
//            helper(dungeon, row-1, i, row-1, i + 1);
//        }
//        for (int i = row - 2; i >= 0; i --) {
//            helper(dungeon, i, col -1, i + 1, col - 1);
//        }
//
//        for (int i = row - 2; i >= 0; i --) {
//            for (int j = col - 2; j >= 0; j--) {
//                int r1 = dungeon[i][j + 1] + dungeon[i][j];
//                int r2 = dungeon[i + 1][j] + dungeon[i][j];
//                if (r1 > 0) {
//                    r1 = 0;
//                } else if (r2 > 0) {
//                    r2 = 0;
//                }
//
//                if (r1 < 0 && r2 < 0) {
//                    dungeon[i][j] = Math.max(r1, r2);
//                } else {
//                    dungeon[i][j] = 0;
//                }
//
//            }
//        }
//        return dungeon[0][0] >= 0 ? 1 : 1 - dungeon[0][0];
//    }


/**

if d[i] 为正 且 d[i + 1]为正，then dp[i]=0
if d[i] 为正 且 d[i + 1]为负，then dp[i] = d[i + 1] + d[i] 为负数
if d[i] 为负 且 d[i + 1]为负，then dp[i] = d[i + 1] + d[i] 为负数
if d[i] 为负 且 d[i + 1]为正，then dp[i] = d[i] 不需要变化

 */

    public void helper(int[][] dungeon, int x, int y, int x1, int y1) {
        if (dungeon[x][y] >= 0 && dungeon[x1][y1] >= 0) {
            dungeon[x][y] = 0;
        }
        if (dungeon[x][y] >= 0 && dungeon[x1][y1] < 0) {
            dungeon[x][y] = dungeon[x][y];
        }
        if (dungeon[x1][y1] < 0 ) {
            dungeon[x][y] = dungeon[x][y] + dungeon[x1][y1];
            if (dungeon[x][y] >= 0) {
                dungeon[x][y] = 0;
            }
        }
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length, col = dungeon[0].length;

        for (int i = col - 2; i >= 0; i --) {
            helper(dungeon, row-1, i, row-1, i + 1);
        }
        for (int i = row - 2; i >= 0; i --) {
            helper(dungeon, i, col -1, i + 1, col - 1);
        }

        for (int i = row - 2; i >= 0; i --) {
            for (int j = col - 2; j >= 0; j--) {
                int r1 = dungeon[i][j + 1] + dungeon[i][j];
                int r2 = dungeon[i + 1][j] + dungeon[i][j];

                if (r1 < 0 && r2 < 0) {
                    dungeon[i][j] = Math.max(r1, r2);
                } else {
                    dungeon[i][j] = 0;
                }

            }
        }
        return dungeon[0][0] >= 0 ? 1 : 1 - dungeon[0][0];
    }



    public static void main(String[] args) {
        int [][] grid = new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}};

//        int [][] grid = new int[][]{
//                {-3, 5}};

//        int [][] grid = new int[][]{
//                {1,-2,3},
//                {2,-2,-2}
//        };

//
//        int [][] grid = new int[][]{
//                {100}};

        SolutionRecursive solution = new SolutionRecursive();
        int sum = solution.calculateMinimumHP(grid);
        System.out.println(sum);
    }
}
