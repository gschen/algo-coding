package edu.sctu.algo.backtracking;

import edu.sctu.algo.utils.PrintUtils;

public class NQueenProblem {

    private int N;
    private int[][] board;

    public NQueenProblem(int n) {
        this.N = n;
        this.board = new int[N][N];
    }

    public boolean solve(int col) {

        if (col >= N)
            return true;

        for (int row = 0; row < N; row++) {

            if (isSafe(row, col)) {

                board[row][col] = 1;

                if (solve(col + 1)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int row, int col) {

        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    public void run() {

        solve(0);
        PrintUtils.printArray(board);
    }

    public static void main(String[] args) {
        new NQueenProblem(8).run();
    }
}
