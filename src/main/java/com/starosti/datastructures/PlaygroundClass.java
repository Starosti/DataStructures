package com.starosti.datastructures;

import com.starosti.datastructures.linkedlist.LinkedListUtils;
import com.starosti.datastructures.linkedlist.doubly.DoublyLinkedList;

public class PlaygroundClass {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1, 2, 4, 6);

        System.out.println(LinkedListUtils.toString(list));
        // [1, 2, 4, 6]

        list.insertDataInIndex(-1,0);
        System.out.println(LinkedListUtils.toString(list));
        // [-1, 1, 2, 4, 6]

        list.insertDataInIndex(7,5);
        System.out.println(LinkedListUtils.toString(list));
        // [-1, 1, 2, 4, 6, 7]

        list.removeNodeInIndex(5);
        System.out.println(LinkedListUtils.toString(list));
        // [-1, 1, 2, 4, 6]

        list.removeNodeInIndex(3);
        System.out.println(LinkedListUtils.toString(list));
        // [-1, 1, 2, 6]

        list.removeNodeInIndex(0);
        System.out.println(LinkedListUtils.toString(list));
        // [1, 2, 6]

        list.replaceDataInIndex(3,0);
        System.out.println(LinkedListUtils.toString(list));
        // [3, 2, 6]

        list.replaceDataInIndex(4,1);
        System.out.println(LinkedListUtils.toString(list));
        // [3, 4, 6]

        list.replaceDataInIndex(7,2);
        System.out.println(LinkedListUtils.toString(list));
        // [3, 4, 7]

    }
}
