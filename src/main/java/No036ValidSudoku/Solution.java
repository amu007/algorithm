package No036ValidSudoku;

import java.util.HashSet;
import java.util.Set;

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true


Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == (board[i][j])) {
                    if (seen(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean seen(char[][] board, int x, int y) {
        Set<Character> set = new HashSet<>();
        for (int i = 1; i <=9; i ++) {
            set.add((i+"").charAt(0));
        }
        for (int i = (x/3) * 3 ; i < (x/3 + 1) * 3; i ++) {
            for (int j = (y/3) * 3 ; j < (y/3 + 1) * 3; j ++) {
                System.out.println(i +"\t"+ j);
                set.remove(board[i][j]);
            }
        }
        for (int i = 0; i < 9; i ++) {
            set.remove(board[x][i]);
            set.remove(board[i][y]);
        }
        boolean result = false;

        if (set.size() == 0) {
            return false;
        }

        for (Character s : set) {
            board[x][y] = s;
            result = isValidSudoku(board);
            if (result != true) {
                board[x][y] = '.';
                continue;
            } else {
//                return true;
            }
//            result = true;
        }

        return result;
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

//        char[][] s = new char[][] {
//                {'1','2','3','4','5','6','7','8','9'},
//                {'4','5','6','7','8','9','1','2','3'},
//                {'7','8','9','1','2','3','4','5','6'},
//                {'2','3','1','5','6','4','8','9','7'},
//                {'5','6','4','8','9','7','2','3','1'},
//                {'8','9','7','2','3','1','5','6','4'},
//                {'3','1','2','6','4','5','9','7','8'},
//                {'6','4','5','9','7','8','3','1','2'},
//                {'9','7','8','3','1','2','6','4','5'}
//        };
//        char[][] s = new char[][] {
//                {'.','.','.','.','.','.','.','.','.'},
//                {'4','5','6','7','8','9','.','2','.'},
//                {'7','8','9','1','2','3','.','.','.'},
//                {'2','3','1','.','6','4','8','9','7'},
//                {'5','6','4','8','9','7','2','3','1'},
//                {'8','9','7','2','3','1','5','6','4'},
//                {'3','1','2','6','4','5','9','7','8'},
//                {'6','4','5','9','7','8','3','1','2'},
//                {'9','7','8','3','1','2','6','4','5'}
//        };


//        char[][] s = new char[][] {
//                {'5','3','1','6','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };


        Solution solution = new Solution();
        boolean result = solution.isValidSudoku(s);
        System.out.println(result);

        for (int i =0; i < 9; i ++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
