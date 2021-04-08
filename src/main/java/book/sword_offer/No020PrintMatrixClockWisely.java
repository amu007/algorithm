package book.sword_offer;

public class No020PrintMatrixClockWisely {
    public void printMatrixClockWisely(int[][] matrix) {
        int columns = matrix[0].length;
        int rows = matrix.length;

        int start = 0;
//        for (int i = 0; i < columns; i ++) {
//            printMatrixCircle(matrix, columns, rows, i);
//        }
        while (columns > start * 2 && rows > start * 2) {
            printMatrixCircle(matrix, columns, rows, start);
            ++start;
        }
//        printMatrixCircle(matrix, columns, rows, 1);
//        printMatrixCircle(matrix, columns, rows, 2);

    }

    public void printMatrixCircle(int[][] matrix, int columns, int rows, int start) {
        int endCol = columns - start - 1;
        int endRow = rows - start - 1;

//        if (start < endCol) {
            for (int i = start; i <= endCol; i++) {
                System.out.print(matrix[start][i]+",");
            }
//        }
        if (start < endRow) {
            for(int i = start + 1; i <= endRow; i ++) {
                System.out.print(matrix[i][endCol]+",");
            }
        }
        if (start < endCol - 1 && start < endRow) {
            for(int i = endCol - 1; i >= start; i --) {
                System.out.print(matrix[endRow][i]+",");
            }
        }
        if (start < endRow && start < endRow - 1) {
            for(int i = endCol - 1; i >= start + 1; i --) {
                System.out.print(matrix[i][start]+",");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 2, 3, 4},
                { 5, 6, 7, 8},
                { 9,10,11,12},
                {13,14,15,16}};

        int[][] matrix2 = new int[][]{
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};

        int[][] matrix3 = new int[][]{
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}};


        int[][] matrix4 = new int[][]{
                { 1},
                { 6},
                {11},
                {16}};

        No020PrintMatrixClockWisely impl = new No020PrintMatrixClockWisely();
        impl.printMatrixClockWisely(matrix2);
    }
}
