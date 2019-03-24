package edu.sctu.algo.utils;

public class PrintUtils {

    public static final void printArray(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                System.out.print(String.format("%-4d", a[i][j]));
            }
            System.out.println();
        }
    }


    public static final void printArray(char[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                System.out.print(String.format("%-4c", a[i][j]));
            }
            System.out.println();
        }
    }


    public static final void printArray(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(String.format("%-4d", a[i]));
        }
        System.out.println();
    }

    public static void printArray(String[] solution) {

        for (int i = 0; i < solution.length && solution[i] != null; i++) {
            System.out.print(String.format("%-4s", solution[i]));

        }

        System.out.println();
    }
}
