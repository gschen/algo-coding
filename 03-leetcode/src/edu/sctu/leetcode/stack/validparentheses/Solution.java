package edu.sctu.leetcode.stack.validparentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (Character ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);
            }

            if (ch == ')') {

                if (!stack.isEmpty() && stack.pop() == '(')
                    continue;

                return false;
            }

            if (ch == ']') {

                if (!stack.isEmpty() && stack.pop() == '[')
                    continue;

                return false;
            }

            if (ch == '}') {

                if (!stack.isEmpty() && stack.pop() == '{')
                    continue;

                return false;
            }


        }

        if (stack.empty())
            return true;


        return false;

    }
}
