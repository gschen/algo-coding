package edu.sctu.algo.backtracking;

import edu.sctu.algo.utils.PrintUtils;

//https://www.geeksforgeeks.org/sudoku-backtracking-7/
public class SudokuProblemV2 {

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 每一次递归都找到一个值为0的空格
                if (board[i][j] == 0) {

                    // 从1到N不停的尝试，
                    for (int num = 1; num <= N; num++) {

                        // 先找到一个没有冲突的数字
                        if (isSafe(i, j, num)) {

                            // 先尝试设置为num
                            board[i][j] = num;

                            if (solve())
                                return true;

                            // 无法前进时，回溯设置为0
                            board[i][j] = 0;
                        }

                    }

                    return false;
                }
            }
        }

        return true;
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

        // check box
        if (checkBoxV2(row, col, num)) return false;

        return true;
    }

    // 检查(row,col)所在的宫是否冲突。
    private boolean checkBoxV2(int row, int col, int num) {

        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {

                if (board[i][j] == num)
                    return true;
            }
        }

        return false;
    }

    private boolean checkBoxV1(int row, int col, int num) {
        int palace = (int) Math.sqrt(N);
        int palaceX = row / palace;
        int palaceY = col / palace;

        for (int i = palaceX * palace; i < (palaceX + 1) * palace; i++) {

            for (int j = palaceY * palace; j < (palaceY + 1) * palace; j++) {

                if (board[i][j] == num) {

//                    System.out.println(String.format("Palace Error (%s, %s)", palaceX, palaceY));
                    return true;
                }
            }
        }
        return false;
    }


    public void run() {

        if (solve()) {

            PrintUtils.printArray(board);

        } else {
            System.out.println("No Solution!");
        }

    }

    public static void main(String[] args) {

        new SudokuProblemV2().run();
    }
}
