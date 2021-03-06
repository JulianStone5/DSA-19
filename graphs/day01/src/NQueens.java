import java.util.ArrayList;
import java.util.List;

public class NQueens {


    /**
     * Checks the 45° and 135° diagonals for an existing queen. For example, if the board is a 5x5
     * and you call checkDiagonal(board, 3, 1), The positions checked for an existing queen are
     * marked below with an `x`. The location (3, 1) is marked with an `o`.
     *
     * ....x
     * ...x.
     * x.x..
     * .o...
     * .....
     *
     * Returns true if a Queen is found.
     *
     * Do not modify this function (the tests use it)
     */
    public static boolean checkDiagonal(char[][] board, int r, int c) {
        int y = r - 1;
        int x = c - 1;
        while (y >= 0 && x >= 0) {
            if (board[y][x] == 'Q') return true;
            x--;
            y--;
        }
        y = r - 1;
        x = c + 1;
        while (y >= 0 && x < board[0].length) {
            if (board[y][x] == 'Q') return true;
            x++;
            y--;
        }
        return false;
    }

    private static boolean checkColumn(char[][] board, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') { return false; }
        }
        return true;
    }

    private static boolean checkAll(char[][] board, int row, int col) {
        return !checkDiagonal(board,row,col) && checkColumn(board, row, col);
    }


    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }


    public static List<char[][]> nQueensSolutions(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<char[][]> answers = new ArrayList<>();
        recSol(board, 0, answers);
        return answers;
    }

    private static void recSol(char[][] board, int row, List<char[][]> answers) {
        char[][] b = copyOf(board);
        if(row >= b.length) {
            answers.add(b);
            return;
        }
        for(int i = 0; i < b.length; i++) {
            if(checkAll(b, row, i)) {
                b[row][i] = 'Q';
                recSol(b, row+1,answers);
                b[row][i] = '.';
            }
        }
    }

}
