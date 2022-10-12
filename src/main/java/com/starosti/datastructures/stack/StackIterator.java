package com.starosti.datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIterator<T> implements Iterator<T> {

    Stack<T> stack;

    public StackIterator(Stack<T> stack){
        this.stack = stack;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return stack.pop();
    }
}
