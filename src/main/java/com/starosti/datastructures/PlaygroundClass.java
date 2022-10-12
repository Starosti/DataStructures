package com.starosti.datastructures;

import com.starosti.datastructures.stack.Stack;
import com.starosti.datastructures.stack.StackUtils;

public class PlaygroundClass {
    public static void main(String[] args) {

        Stack<Integer> stackIterate = new Stack<>(1,2,3,4,5);
        System.out.println(StackUtils.toString(stackIterate));
        for(int i : stackIterate){
            System.out.println(i);
            System.out.println(StackUtils.toString(stackIterate));
        }

        Stack<Integer> stack = new Stack<>(1,2,3,4,5);
        System.out.println(StackUtils.toString(stack));


        stack.pop();
        System.out.println(StackUtils.toString(stack));

        System.out.println(stack.peek());

        stack.push(7);
        System.out.println(StackUtils.toString(stack));
    }
}
