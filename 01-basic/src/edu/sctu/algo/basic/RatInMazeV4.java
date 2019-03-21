package edu.sctu.algo.basic;

import edu.sctu.algo.utils.PrintUtils;

// Rat can run in four directions.
// https://algorithms.tutorialhorizon.com/backtracking-rat-in-a-maze-puzzle/
public class RatInMazeV4 {

    private int[][] maze = new int[][]{
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 1}
    };
    private int N = maze.length;
    private int[][] solution = new int[N][N];
    private Point start;
    private Point end;

    public RatInMazeV4() {
        this.start = new Point(0, 0);
        this.end = new Point(N - 1, N - 1);
    }

    public boolean solve(int x, int y, Direction direction) {

        if (x == end.x && y == end.y) {

            solution[x][y] = 1;
            return true;
        }

        if (isSafe(x, y)) {

            solution[x][y] = 1;

            if (direction != Direction.UP && solve(x + 1, y, Direction.DOWN)) {
                return true;
            }

            if (direction != Direction.DOWN && solve(x - 1, y, Direction.UP)) {
                return true;
            }

            if (direction != Direction.LEFT && solve(x, y + 1, Direction.RIGHT)) {
                return true;
            }

            if (direction != Direction.RIGHT && solve(x, y - 1, Direction.LEFT)) {
                return true;
            }

            solution[x][y] = 0;

        }

        return false;
    }

    public void run() {

        System.out.println("Maze is: ");
        PrintUtils.printArray(maze);


        if (solve(start.x, start.y, Direction.DOWN)) {

            System.out.println("Solution is: ");
            PrintUtils.printArray(solution);
        } else {
            System.out.println("No Path Found!");
        }
    }

    private boolean isSafe(int x, int y) {
        return (
                x >= 0 && x < N && y >= 0 && y < N && maze[x][y] != 0
        );
    }

    public static void main(String[] args) {

        new RatInMazeV4().run();

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

    enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

}
