package com.starosti.datastructures.stack;

import com.starosti.datastructures.linkedlist.singly.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>(1,2,3,4,5,6,7,8,9,10);
    }

    @Test
    void pop() {
        int i = 1;
        while (!stack.isEmpty()){
            assertEquals(i, stack.pop());
            i++;
        }
    }

    @Test
    void peek() {
        int i = 1;
        while (!stack.isEmpty()){
            assertEquals(i, stack.peek());
            i++;
            stack.pop();
        }
    }

    @Test
    void push() {
        int i = 11;
        for (int j = 0; j < 10; j++) {
            stack.push(i);
            assertEquals(i, stack.peek());
            i++;
        }
    }

    @Test
    void isEmpty() {
        assertFalse(stack.isEmpty());
        for (int i = 0; i < 10; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    void getLength() {
        int i = 10;
        while (!stack.isEmpty()){
            assertEquals(i, stack.getLength());
            stack.pop();
            i--;
        }
    }

    @Test
    void iterator() {
        int i = 1;
        for (Integer integer : stack) {
            assertEquals(i, integer);
            i++;
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    void asList() {
        assertEquals(10, stack.asList().getLength());
        int i = 1;
        for (Integer integer : stack.asList()) {
            assertEquals(i, integer);
            i++;
        }
    }

    @Test
    void listIterator() {
        int i = 1;
        assertEquals(10, stack.asList().getLength());
        assertEquals(SinglyLinkedList.class,stack.asList().getClass());
        Iterator<Integer> stackIterator = stack.listIterator();
        while (stackIterator.hasNext()){
            assertEquals(i, stackIterator.next());
            i++;
        }
    }
}