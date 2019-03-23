package edu.sctu.algo.backtracking;

import edu.sctu.algo.utils.PrintUtils;

public class RatInMazeV1 {

    private int[][] maze = new int[][]{
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1},
    };
    private int N = maze.length;
    private int[][] solution = new int[N][N];

    public boolean solve(int x, int y) {

        if (x == N - 1 && y == N - 1) {

            solution[x][y] = 1;
            return true;
        }

        if (isSafe(x, y)) {

            solution[x][y] = 1;

            if (solve(x + 1, y)) {
                return true;
            }

            if (solve(x, y + 1)) {
                return true;
            }

            solution[x][y] = 0;

        }

        return false;
    }

    public void run() {

        System.out.println("Maze is: ");
        PrintUtils.printArray(maze);

        solve(0, 0);

        System.out.println("Solution is: ");
        PrintUtils.printArray(solution);
    }

    private boolean isSafe(int x, int y) {
        return (
                x >= 0 && x < N && y >= 0 && y < N && maze[x][y] != 0
        );
    }

    public static void main(String[] args) {

        new RatInMazeV1().run();

    }
}
