package com.starosti.datastructures.stack;

import com.starosti.datastructures.linkedlist.LinkedListUtils;

public class StackUtils {

    private StackUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> T[] toArray(Stack<T> stack, Class<T> clazz){
        return LinkedListUtils.toArray(stack.asList(),clazz);
    }

    public static <T> String toString(Stack<T> stack){
        return stack.getClass().getSimpleName()+": "+LinkedListUtils.toStringWithoutClassName(stack.asList());
    }

    public static <T> String toStringWithoutClassName(Stack<T> stack){
        return LinkedListUtils.toStringWithoutClassName(stack.asList());
    }

    public static <T> void printStack(Stack<T> stack){
        LinkedListUtils.printList(stack.asList());
    }
}
