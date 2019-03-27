package edu.sctu.leetcode.evalrpn;

import java.util.Stack;

class Solution {

    private Stack<Integer> stack = new Stack<Integer>();

    public int evalRPN(String[] tokens) {

        int op1 = 0;
        int op2 = 0;

        for (String str : tokens) {

            switch (str) {
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();

                    stack.push(op1 + op2);
                    break;

                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();

                    stack.push(op1 - op2);
                    break;

                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();

                    stack.push(op1 * op2);
                    break;

                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();

                    stack.push(op1 / op2);
                    break;

                default:
                    stack.push(Integer.valueOf(str));
                    break;

            }

        }

        return stack.pop();
    }


}