package edu.sctu.algo.backtracking;

import edu.sctu.algo.utils.PrintUtils;

// https://algorithms.tutorialhorizon.com//backtracking-search-a-word-in-a-matrix/
public class SearchWordInMatrix {

    private char[][] matrix;
    private int[][] solution;
    private int M;
    private int N;
    private String word;


    public SearchWordInMatrix() {

        matrix = new char[][]{
                {'t', 'z', 'x', 'c', 'd'},
                {'a', 'h', 'n', 'z', 'x'},
                {'h', 'w', 'o', 'i', 'o'},
                {'o', 'r', 'n', 'r', 'n'},
                {'a', 'b', 'r', 'i', 'n'}
        };

        M = matrix.length;
        N = matrix[0].length;

        solution = new int[M][N];

        word = "horizon";
    }

    public void run() {

        System.out.println("Matrix is: ");
        PrintUtils.printArray(matrix);

        boolean findPath = false;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (solve(i, j, 0)) {
                    findPath = true;
                    break;
                }
            }
        }

        if (findPath) {
            System.out.println("Solution is: ");
            PrintUtils.printArray(this.solution);
        } else {
            System.out.println("No Path!");
        }
    }


    // 针对每一个位置(row,col)按照上、下、左、右、正对角线、反对角线位置开始查找。
    private boolean solve(int row, int col, int index) {

        if (index == word.length()) {
            return true;
        }

        if (word.charAt(index) == matrix[row][col]) {

            solution[row][col] = (index++ + 1);

            //right, left, up, down and diagonally
            if (row + 1 < M && solve(row + 1, col, index)) {
                return true;
            }

            if (row - 1 >= 0 && solve(row - 1, col, index)) {
                return true;
            }

            if (col + 1 < N && solve(row, col + 1, index)) {
                return true;
            }

            if (col - 1 >= 0 && solve(row, col - 1, index)) {
                return true;
            }

            if (row + 1 < M && col + 1 < N && solve(row + 1, col + 1, index)) {
                return true;
            }

            if (row - 1 >= 0 && col - 1 >= 0 && solve(row - 1, col - 1, index))
                return true;

            if (row - 1 >= 0 && col + 1 < N && solve(row - 1, col + 1, index))
                return true;

            if (row + 1 < M && col - 1 >= 0 && solve(row + 1, col - 1, index))
                return true;

            solution[row][col] = 0;
            index--;
        }

        return false;
    }


    public static void main(String[] args) {


        new SearchWordInMatrix().run();
    }
}
