package edu.sctu.algo.backtracking;

//https://algorithms.tutorialhorizon.com/the-word-break-problem/

import edu.sctu.algo.utils.PrintUtils;

/**
 * Objective : Given an string and a dictionary of words,
 * find out if the input string can be broken into a space-separated sequence of one or more dictionary words.
 * <p>
 * Example:
 * <p>
 * dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]
 * <p>
 * String = "IamSumit"
 * <p>
 * Output: "I am Sumit"
 * <p>
 * String ="thisisadog"
 * <p>
 * Output : String can't be broken
 */
public class WordBreakProblem {

    public static final String ERROR = "String can't be broken";

    private String[] dictionary;
    private int N;
    private String[] solution;
    private String target;

    public WordBreakProblem() {

        dictionary = new String[]{
                "I", "have", "Jain", "Sumit", "am", "this", "dog"
        };

        N = dictionary.length;
        solution = new String[N];

        target = "IamthisJain";
    }

    // 词典中是否包含该单词
    private boolean contains(String word) {

        for (int i = 0; i < N; i++) {
            if (dictionary[i].equals(word))
                return true;
        }

        return false;
    }

    private boolean solve(int start, int end, int index) {
        if (end > target.length())
            return true;

        String token = target.substring(start, end);

        if (contains(token)) {

            solution[index++] = token;

            for (int i = 1; i <= N - end + 1; i++) {

                if (solve(end, end + i, index)) {
                    return true;
                }
            }

        }

        return false;
    }

    public void run() {

        solve(0, 1, 0);

        PrintUtils.printArray(solution);

    }

    public static void main(String[] args) {

        new WordBreakProblem().run();
    }
}
