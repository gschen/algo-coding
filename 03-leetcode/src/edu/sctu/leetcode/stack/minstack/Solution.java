package edu.sctu.leetcode.stack.minstack;


import java.util.Stack;

/**
 * 基本思想：每压入一个数都把当前栈内最小的数压入到minStack中
 */
class Solution extends Stack<Integer> {
    public static final int ERROR = -1;
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {

        super.push(x);

        if (minStack.empty()) {
            minStack.push(x);
        } else {

            int min = minStack.peek();

            if (min < x)
                minStack.push(min);
            else
                minStack.push(x);

        }

    }

    public Integer pop() {

        if (!minStack.empty())
            minStack.pop();

        if (!this.empty())
            return pop();

        return ERROR;
    }

    public int getMin() {

        if (!minStack.empty())
            return minStack.peek();

        return ERROR;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
}