package No052NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionDone {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2*n], new boolean[2*n], new String[n], res);
        return res;
    }

    public void helper(int row, boolean[] cols, boolean[] pie, boolean[] na, String[] board, List<List<String>> res) {
        if (row == cols.length) {
            String[] newBoard = board.clone();
            List<String> boardList = new ArrayList<>();
            for (int i = 0; i < newBoard.length; i++) {
                boardList.add(newBoard[i]);
            }
            res.add(boardList);
        } else {
            for (int i = 0; i < cols.length; i ++) {
                int p = row + i;
                int n = row - i + cols.length;

                if(!cols[i] && !pie[p] && !na[n]) {
                    char[] rows = new char[board.length];
                    Arrays.fill(rows, '.');
                    rows[i] = 'Q';
                    board[row] = new String(rows);

                    cols[i] = true; pie[p] = true; na[n] = true;
                    helper(row + 1, cols, pie, na, board, res);
                    cols[i] = false; pie[p] = false; na[n] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionDone solution = new SolutionDone();

        List<List<String>> list = solution.solveNQueens(4);
        for (List<String> board : list) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println("========");
        }
        System.out.println(list.size());
    }
}
