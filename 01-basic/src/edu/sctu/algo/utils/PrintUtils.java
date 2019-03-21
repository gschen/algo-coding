package edu.sctu.algo.utils;

public class PrintUtils {

    public static final void printArray(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                System.out.print(String.format("%-4d", a[i][j]));
            }
            System.out.println();
        }
    }

    public static final void printArray(int[] a){

        for (int i = 0; i < a.length; i++) {
            System.out.print(String.format("%-4d", a[i]));
        }
        System.out.println();
    }
}
