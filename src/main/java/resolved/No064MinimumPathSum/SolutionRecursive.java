package resolved.No064MinimumPathSum;

public class SolutionRecursive {

    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        for (int i = col - 2; i >= 0; i --) {
            grid[row - 1][i] = grid[row - 1][i] + grid[row - 1][i + 1];
        }
        for (int i = row - 2; i >= 0; i --) {
            grid[i][col - 1] = grid[i][col - 1] + grid[i + 1][col - 1];
        }

        for (int i = row - 2; i >= 0; i --) {
            for (int j = col - 2; j >= 0; j--) {
                grid[i][j] = Math.min(grid[i][j + 1] + grid[i][j], grid[i + 1][j] + grid[i][j]);
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{{1,3,1},
                {1,5,1},
                {4,2,1}};

//        int [][] grid = new int[][]{
//                {1,3},
//                {1,5},
//                {4,2}};

        SolutionRecursive solution = new SolutionRecursive();
        int sum = solution.minPathSum(grid);
        System.out.println(sum);
    }
}
