package edu.sctu.algo.backtracking;

import edu.sctu.algo.utils.PrintUtils;

//https://www.geeksforgeeks.org/sudoku-backtracking-7/
public class SudokuProblem {

    int[][] board = new int[][]{
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

    private boolean solve() {

        // 是否还有待处理的空位，即board[i][j] == 0的空位。
        boolean waitToHandle = false;
        int row = -1;
        int col = -1;

        // 找到值为0的空位，然后跳出循环。
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {

                    row = i;
                    col = j;

                    waitToHandle = true;
                    break;
                }
            }

            if (waitToHandle)
                break;
        }

        if (!waitToHandle)
            return true;

        // 1-N 开始不停的试错
        for (int num = 1; num <= N; num++) {
            if (isSafe(row, col, num)) {
                board[row][col] = num;

                if (solve())
                    return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int row, int col, int num) {

        // check row
        for (int i = 0; i < N; i++) {
            if (board[i][col] == num) {
//                System.out.println("Row Error!");
                return false;
            }
        }

        // check column
        for (int i = 0; i < N; i++) {
            if (board[row][i] == num) {
//                System.out.println("Column Error!");
                return false;
            }
        }

        // check palace
        int palace = (int) Math.sqrt(N);
        int palaceX = row / palace;
        int palaceY = col / palace;

        for (int i = palaceX * palace; i < (palaceX + 1) * palace; i++) {

            for (int j = palaceY * palace; j < (palaceY + 1) * palace; j++) {

                if (board[i][j] == num) {

//                    System.out.println(String.format("Palace Error (%s, %s)", palaceX, palaceY));
                    return false;
                }
            }
        }

        return true;
    }


    public void run() {

        if (solve()) {

            PrintUtils.printArray(board);

        } else {
            System.out.println("No Solution!");
        }

    }

    public static void main(String[] args) {

        new SudokuProblem().run();
    }
}
