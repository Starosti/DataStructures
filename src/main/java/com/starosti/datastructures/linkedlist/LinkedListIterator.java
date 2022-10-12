package com.starosti.datastructures.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {

    Node<T> previous;
    Node<T> current;

    public LinkedListIterator(LinkedList<T,?> list)
    {
        current = list.findNodeByIndex(0);
    }

    public boolean hasNext()
    {
        return current != null;
    }

    public T next()
    {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        T data = current.getData();
        previous = current;
        current = current.getNextNode();
        return data;
    }
}