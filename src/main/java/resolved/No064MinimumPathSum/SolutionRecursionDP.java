package resolved.No064MinimumPathSum;

public class SolutionRecursionDP {

    public int minPathSum(int[][] grid) {
        cache = new Integer[grid.length][grid[0].length];
        return helper(grid, 0, 0, 0);
    }

    Integer[][] cache = null;

    public int helper(int[][] grid, int i, int j, int sum) {

        if (cache[i][j] != null) {
            return cache[i][j];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            sum += grid[i][j];

        } else if (i == grid.length - 1) {
            sum += grid[i][j] + helper(grid, i, j + 1, sum);
        } else if (j == grid[0].length - 1) {
            sum += grid[i][j] + helper(grid, i + 1, j, sum);
        } else {
            sum += grid[i][j] + Math.min(helper(grid, i, j + 1, sum), helper(grid, i + 1, j, sum));
        }
        cache[i][j] = sum;
        return sum;
    }

    public static void main(String[] args) {
//        int [][] grid = new int[][]{{1,3,1},
//                {1,5,1},
//                {4,2,1}};

        int [][] grid = new int[][]{{1,3},
                {1,5},
                {4,2}};

        SolutionRecursionDP solution = new SolutionRecursionDP();
        int sum = solution.minPathSum(grid);
        System.out.println(sum);
    }
}
