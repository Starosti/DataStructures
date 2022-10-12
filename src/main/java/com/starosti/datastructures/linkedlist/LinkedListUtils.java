package com.starosti.datastructures.linkedlist;

import java.lang.reflect.Array;
import java.util.StringJoiner;

public class LinkedListUtils {

    private LinkedListUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> T[] toArray(LinkedList<T,? extends Node<T>> linkedList, Class<T> clazz){
        // returns an object array
        int length = linkedList.getLength();
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(clazz,length);
        Node<T> currNode = linkedList.findNodeByIndex(0);
        for(int i = 0; i<length; i++){
            arr[i] = currNode.getData();
            currNode = currNode.getNextNode();
        }
        return arr;
    }

    public static <T> String toString(LinkedList<T,? extends Node<T>> linkedList){
        return linkedList.getClass().getSimpleName()+": "+LinkedListUtils.toStringWithoutClassName(linkedList);
    }

    public static <T> String toStringWithoutClassName(LinkedList<T,? extends Node<T>> linkedList){
        if (linkedList.getLength() == 0){
            return "[]";
        }
        StringJoiner joiner = new StringJoiner(", ");
        Node<T> currNode = linkedList.findNodeByIndex(0);
        int length = linkedList.getLength();
        for(int i = 0; i<length; i++){
            joiner.add(currNode.getData().toString());
            currNode = currNode.getNextNode();
        }
        return "["+joiner+"]";
    }

    public static <T> void printList(LinkedList<T,? extends Node<T>> linkedList){
        Node<T> currNode = linkedList.findNodeByIndex(0);
        int length = linkedList.getLength();
        for(int i = 0; i<length; i++){
            System.out.println(currNode.getData()+" in index "+i);
            currNode= currNode.getNextNode();
        }
    }
}
