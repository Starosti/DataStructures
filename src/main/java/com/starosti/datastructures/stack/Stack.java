package com.starosti.datastructures.stack;

import com.starosti.datastructures.linkedlist.LinkedListIterator;
import com.starosti.datastructures.linkedlist.singly.SinglyLinkedList;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {


    /** Stack is essentially a singly linked list which only enables operations
     *  with the head. So; we can just use a singly linked list under the hood
     *  for the implementation, and make Stack class act kinda like a wrapper.
     */
    private final SinglyLinkedList<T> stackList;

    @SafeVarargs
    public Stack(T... elements) {
        this.stackList = new SinglyLinkedList<>(elements);
    }

    public void push(T data){
        this.stackList.replaceDataInIndex(data, 0);
    }

    public T pop(){
        T data = this.peek();
        stackList.removeNodeInIndex(0);
        return data;
    }

    public boolean isEmpty(){
        return stackList.getLength() == 0;
    }

    public T peek(){
        return stackList.getHead().getData();
    }

    public int getLength(){
        return stackList.getLength();
    }

    public SinglyLinkedList<T> asList(){
        return this.stackList;
    }

    // WARNING: This will pop elements from the stack!!
    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>(this);
    }

    public Iterator<T> listIterator() {
        return new LinkedListIterator<>(this.stackList);
    }
}
