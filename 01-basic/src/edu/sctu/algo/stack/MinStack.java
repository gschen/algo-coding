package edu.sctu.algo.stack;

import java.util.Stack;

/**
 * 双栈
 *
 *
 */
public class MinStack extends Stack<Integer> {

    public static final int ERROR = -1;

    private Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    @Override
    public Integer push(Integer item) {

        if (super.empty()){

            minStack.push(item);
            super.push(item);
        }else{
            super.push(item);

            int min = minStack.peek();
            if (item < min){

                minStack.push(item);
            }else{


                minStack.push(min);
            }

        }

        return item;
    }

    @Override
    public synchronized Integer pop() {

        if (!super.empty()){
            minStack.pop();
            return super.pop();
        }

        return ERROR;
    }

    public static void main(String[] args) {


    }
}
