package edu.sctu.algo.stack;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 回文判断
 * abccba
 * abcdcba
 * 基本思想：一分为二，左边所有元素进栈，右边所有元素进队列。
 */
public class PalindromeProblem {

    private Stack<Character> stack;
    private Queue<Character> queue;
    private String str;

    public PalindromeProblem(String str) {
        this.stack = new Stack<>();
        this.queue = new LinkedList<Character>();
        this.str = str;
    }

    public boolean isPalindrome() {

        int len = this.str.length();

        int rightStart = len % 2 == 0 ? len / 2 : len / 2 + 1;


        for (int i = 0; i < len / 2; i++) {
            stack.push(str.charAt(i));
            queue.offer(str.charAt(rightStart + i));
        }


        int ch;
        while (!stack.empty()) {

            if (stack.pop() != queue.poll())
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(new PalindromeProblem("abcdecba").isPalindrome());

    }
}
