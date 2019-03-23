package edu.sctu.algo.backtracking;

import edu.sctu.algo.utils.PrintUtils;

public class FromTopLeftToBottomRightPath {

    private static int M = 0;
    private static int N = 0;
    private int[][] matrix;
    private int[][] solutions;

    public FromTopLeftToBottomRightPath() {

        this.matrix = new int[][]{
                {1,2,3},
                {4,5,6}
        };

        this.M = matrix.length;
        this.N = matrix[0].length;

        this.solutions = new int[M][N];
    }

    private boolean solve(int x, int y) {

        if (x == M - 1 && y == N - 1) {

            solutions[x][y] = 1;
            return true;
        }

        if (isSafe(x, y)) {

            solutions[x][y] = 1;

            if (solve(x + 1, y))
                return true;

            if (solve(x, y + 1)) {
                return true;
            }

            solutions[x][y] = 0;

        }
        return false;
    }

    private boolean isSafe(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    private void run() {

        System.out.println("Matrix is: ");
        PrintUtils.printArray(matrix);

        if (solve(0, 0)) {

            System.out.println("Solution is: ");
            PrintUtils.printArray(solutions);
        } else {
            System.out.println("No Path!");
        }
    }


    public static void main(String[] args) {

        new FromTopLeftToBottomRightPath().run();
    }
}
