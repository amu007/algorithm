package No037SudokuSolver;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public boolean helper(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == (board[i][j])) {
                    for (char k = 1; k <= 9; k ++) {
                        board[i][j] = k;
                        boolean result = valid(board, i, j);
                        if (!result) {
                            board[i][j] = '.';
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int x, int y) {
        for (int i = (x/3) * 3 ; i < (x/3 + 1) * 3; i ++) {
            for (int j = (y/3) * 3 ; j < (y/3 + 1) * 3; j ++) {
                if (i != x )
                if (board[i][j] == board[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] s = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        Solution solution = new Solution();
        solution.solveSudoku(s);

        for (int i =0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
