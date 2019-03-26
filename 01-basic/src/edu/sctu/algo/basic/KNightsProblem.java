package edu.sctu.algo.basic;

import edu.sctu.algo.utils.PrintUtils;

public class KNightsProblem {

    private int M = 5;
    private int N = 5;
    private int K = 13;
    // 0 for none
    // 1 for knight
    private int[][] board = new int[M][N];

    private int numOfKnights = 0;


    private boolean solve(int x, int y) {

        if (isSafe(x, y)) {

            board[x][y] = 1;

            if (solve(x + 2, y + 1))
                return true;

            if (solve(x + 2, y - 1))
                return true;

            if (solve(x - 2, y + 1))
                return true;

            if (solve(x - 2, y - 1)) {
                return true;
            }

            if (solve(x + 1, y + 2)) {
                return true;
            }

            if (solve(x - 1, y + 2)) {
                return true;
            }

            if (solve(x+1, y-2)) {
                return true;
            }

            if (solve(x-1, y -2)) {
                return true;
            }

            board[x][y] = 0;
        }


        return false;
    }

    private boolean isSafe(int row, int col) {

        if ((row + 2 < M) && (col + 1 < N) && board[row + 2][col + 1] == 1)
            return false;

        if ((row + 2 < M) && (col - 1 >= 0) && board[row + 2][col - 1] == 1)
            return false;

        if ((row - 2 >= 0) && (col + 1 < N) && board[row - 2][col + 1] == 1)
            return false;

        if ((row - 2 >= 0) && (col - 1 >= 0) && board[row - 2][col - 1] == 1)
            return false;


        if (row - 1 >= 0 && col + 2 < N && board[row - 1][col + 2] == 1)
            return false;


        if (row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2] == 1)
            return false;


        if (row + 1 < M && col + 2 < N && board[row + 1][col + 2] == 1)
            return false;


        if (row + 1 < M && col - 2 >= 0 && board[row + 1][col - 2] == 1)
            return false;

        return true;
    }

    public void run() {

        if (solve(0,0))
            PrintUtils.printArray(board);
        else
            System.out.println("No Solution!");
    }


    public static void main(String[] args) {

        new KNightsProblem().run();

    }
}
