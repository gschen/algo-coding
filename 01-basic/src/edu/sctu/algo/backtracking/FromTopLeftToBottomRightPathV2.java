package edu.sctu.algo.backtracking;

import edu.sctu.algo.utils.PrintUtils;

public class FromTopLeftToBottomRightPathV2 {

    private static int M = 0;
    private static int N = 0;
    private int[][] matrix;
    private int[][] solutions;

    public FromTopLeftToBottomRightPathV2() {

        this.matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
        };

        this.M = matrix.length;
        this.N = matrix[0].length;

        this.solutions = new int[M][N];
    }

    private void solve(int x, int y, String path) {

        if (x == M - 1) {

            for (int i = y; i < N; i++) {
                path += String.format("%-4s", matrix[x][i]);
            }

            System.out.println(path);
            return;
        }

        if (y == N - 1) {

            for (int i = x; i < M; i++) {
                path += String.format("%-4s", matrix[i][y]);
            }

            System.out.println(path);
            return;

        }

        path += String.format("%-4s", matrix[x][y]);

        solve(x + 1, y, path);
        solve(x, y + 1, path);

    }


    private void run() {

        System.out.println("Matrix is: ");
        PrintUtils.printArray(matrix);

        System.out.println("All possible paths are: ");
        solve(0, 0, "");

    }


    public static void main(String[] args) {

        new FromTopLeftToBottomRightPathV2().run();
    }
}
