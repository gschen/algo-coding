package edu.sctu.algo.basic;

import edu.sctu.algo.utils.PrintUtils;


//https://www.geeksforgeeks.org/sudoku-backtracking-7/
public class SudokuProblem {

    int[][] board = new int[][]
            {
                    {3, 0, 6, 5, 0, 8, 4, 0, 0},
                    {5, 2, 0, 0, 0, 0, 0, 0, 0},
                    {0, 8, 7, 0, 0, 0, 0, 3, 1},
                    {0, 0, 3, 0, 1, 0, 0, 8, 0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                    {0, 5, 0, 0, 9, 0, 6, 0, 0},
                    {1, 3, 0, 0, 0, 0, 2, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 7, 4},
                    {0, 0, 5, 2, 0, 6, 3, 0, 0}
            };
    int N = board.length;

    private boolean solve(int x, int y) {

        if (x == N - 1 && y == N - 1) {
            return true;
        }

        if (board[x][y] != 0 && isSafe(x, y)) {

            for (int i = 0; i < 9; i++) {

                board[x][y] = i;

                if (solve(x + 1, y)) {
                    return true;
                }

                if (solve(x, y + 1)) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {

        for (int i = 0; i < N; i++) {
            if (board[i][col] == 1)
                return false;
        }

        for (int i = 0; i < N; i++) {
            if (board[row][i] == 1)
                return false;
        }


        return true;
    }

    public void run() {

        solve(0, 0);

        PrintUtils.printArray(board);

    }

    public static void main(String[] args) {

        new SudokuProblem().run();

    }
}
