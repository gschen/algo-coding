package edu.sctu.algo.backtracking;

import edu.sctu.algo.utils.PrintUtils;

// Given any start, end position.
public class RatInMazeV2 {

    private int[][] maze = new int[][]{
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1},
    };
    private int N = maze.length;
    private int[][] solution = new int[N][N];
    private Point start;
    private Point end;

    public RatInMazeV2() {
        this.start = new Point(0, 0);
        this.end = new Point(3, 3);
    }

    public boolean solve(int x, int y) {

        if (x == end.x && y == end.y) {

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

        solve(start.x, start.y);

        System.out.println("Solution is: ");
        PrintUtils.printArray(solution);
    }

    private boolean isSafe(int x, int y) {
        return (
                x >= 0 && x < N && y >= 0 && y < N && maze[x][y] != 0
        );
    }

    public static void main(String[] args) {

        new RatInMazeV2().run();

    }

    class Point {
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
