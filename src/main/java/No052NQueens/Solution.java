package No052NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2*n], new boolean[2*n], new String[n], res);
        return res;
    }

    private void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<String[]> res) {
        if (r == board.length) {
            res.add(board.clone());
        }
        else {
            for (int c = 0; c < board.length; c ++) {
                int id1 = r - c + board.length, id2 = 2*board.length -r - c - 1;
                if (!cols[c] && !d1[id1] && !d2[id2]) {
                    char[] rows = new char[board.length];
                    Arrays.fill(rows, '.');
                    rows[c] = 'Q';

                    board[r] = new String(rows);
                    cols[c] = true; d1[id1] = true; d2[id2] = true;
                    helper(r + 1, cols, d1, d2, board, res);
//                    System.out.println("#######"+r);
                    cols[c] = false; d1[id1] = false; d2[id2] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String[]> list = solution.solveNQueens(5);
        for (String[] board : list) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println("========");
        }
        System.out.println(list.size());
    }
}
