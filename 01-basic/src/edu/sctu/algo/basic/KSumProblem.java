package edu.sctu.algo.basic;

import edu.sctu.algo.utils.PrintUtils;

public class KSumProblem {
    int n = 4;
    int[] a = {1, 2, 4, 7};
    int k = 9;

    int[] solution = new int[a.length];


    private boolean solve(int i, int sum) {
        if (sum == k)
            return true;

        if (i >= n)
            return false;

        if (sum < k) {

            solution[i] = 1;

            if (solve(i + 1, sum + a[i])) {
                return true;
            }

            solution[i] = 0;

        }


        return false;
    }

    public void run() {

//        if (solve(0, 0)) {
//
//            System.out.println("YES");
//            PrintUtils.printArray(solution);
//        } else {
//            System.out.println("NO");
//        }

        if (dfs(0, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }


    private boolean dfs(int i, int sum) {

        if (i == n)
            return sum == k;

        if (dfs(i + 1, sum + a[i])) {

            return true;
        }


        if (dfs(i + 1, sum)) {

            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        new KSumProblem().run();

    }
}
