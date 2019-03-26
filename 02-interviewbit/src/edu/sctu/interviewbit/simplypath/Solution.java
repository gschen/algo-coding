package edu.sctu.interviewbit.simplypath;

import java.util.Stack;

/**
 *
 Given an absolute path for a file (Unix-style), simplify it.
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class Solution {
    public String simplifyPath(String A) {

        String[] tokens = A.split("\\/");

        Stack<String> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals(".") || token.equals(""))
                continue;

            if (token.equals("..")) {

                if (!stack.empty())
                    stack.pop();
            } else {

                stack.push(token);
            }
        }

        if (stack.empty())
            return "/";

        StringBuilder target = new StringBuilder();

        while (!stack.empty()) {

            target.insert(0, "/" + stack.pop());
        }


        return target.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
    }
}
