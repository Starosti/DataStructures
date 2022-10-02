package com.starosti.datastructures.linkedlist.doubly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> testList;
    private final Integer[] integers = {1, 2, 3, 4, 5, 6};

    @BeforeEach
    void setUp() {
        testList = new DoublyLinkedList<>(integers);
    }

    @Test
    void findNodeByIndex() {
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for(int i = 0; i< integers.length; i++){
            assertEquals(currNode,testList.findNodeByIndex(i));
            assertEquals(integers[i],testList.findNodeByIndex(i).getData());
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void findDataByIndex() {
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for(int i = 0; i< integers.length; i++){
            assertEquals(integers[i],testList.findDataByIndex(i));
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void findNodeByData() {
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : integers) {
            assertEquals(currNode, testList.findNodeByData(integer).orElseThrow());
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void findIndexByData() {
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for(int i = 0; i< integers.length; i++){
            assertEquals(i,testList.findIndexByData(integers[i]).orElseThrow());
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void insertNodeInIndex() {
                                                                                //     1, 2,    3, 4, 5, 6
        testList.insertNodeInIndex(new DoublyLinkedNode<>(5),2);     //     1, 2, 5, 3, 4, 5, 6
        testList.insertNodeInIndex(new DoublyLinkedNode<>(10),0);    // 10, 1, 2, 5, 3, 4, 5, 6
        testList.insertNodeInIndex(new DoublyLinkedNode<>(15),8);    // 10, 1, 2, 5, 3, 4, 5, 6, 15
        Integer[] expected = {10, 1, 2, 5, 3, 4, 5, 6, 15};
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertEquals(expected.length,testList.getLength());
        assertNull(currNode);
    }

    @Test
    void insertDataInIndex() {
                                                     //     1, 2,    3, 4, 5, 6
        testList.insertDataInIndex(5,2);  //     1, 2, 5, 3, 4, 5, 6
        testList.insertDataInIndex(10,0); // 10, 1, 2, 5, 3, 4, 5, 6
        testList.insertDataInIndex(15,8); // 10, 1, 2, 5, 3, 4, 5, 6, 15
        Integer[] expected = {10, 1, 2, 5, 3, 4, 5, 6, 15};
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertEquals(expected.length,testList.getLength());
        assertNull(currNode);
    }

    @Test
    void removeNodeInIndex() {
                                         // 1, 2, 3, 4, 5, 6
        testList.removeNodeInIndex(5);   // 1, 2, 3, 4, 5, _6_ -> 1, 2, 3, 4, 5
        testList.removeNodeInIndex(2);   // 1, 2, _3_, 4, 5,   -> 1, 2, 4, 5,
        testList.removeNodeInIndex(0);   // _1_, 2, 4, 5,      -> 2, 4, 5,
        Integer[] expected = {2, 4, 5};
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertEquals(expected.length,testList.getLength());
        assertNull(currNode);
    }

    @Test
    void replaceDataInIndex() {
                                                        // 1, 2, 3, 4, 5, 6
        testList.replaceDataInIndex(5,2);    // 1, 2, -5-, 4, 5, 6
        testList.replaceDataInIndex(10,0);   // -10-, 2, 5, 4, 5, 6
        testList.replaceDataInIndex(15,5);   // 10, 2, 5, 4, 5, -15-
        Integer[] expected = {10, 2, 5, 4, 5, 15};
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertEquals(expected.length,testList.getLength());
        assertNull(currNode);
    }

    @Test
    void replaceNodeInIndex() {
                                                                                // 1, 2, 3, 4, 5, 6
        testList.replaceNodeInIndex(new DoublyLinkedNode<>(5),2);    // 1, 2, -5-, 4, 5, 6
        testList.replaceNodeInIndex(new DoublyLinkedNode<>(10),0);   // -10-, 2, 5, 4, 5, 6
        testList.replaceNodeInIndex(new DoublyLinkedNode<>(15),5);   // 10, 2, 5, 4, 5, -15-
        Integer[] expected = {10, 2, 5, 4, 5, 15};
        DoublyLinkedNode<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertEquals(expected.length,testList.getLength());
        assertNull(currNode);
    }

    @Test
    void getFirstNode() {
        DoublyLinkedNode<Integer> newFirstNode = new DoublyLinkedNode<>(10);
        DoublyLinkedNode<Integer> nextNode = new DoublyLinkedNode<>(15);
        newFirstNode.setNextNode(nextNode);
        nextNode.setPreviousNode(newFirstNode);
        testList.setFirstNode(newFirstNode);
        assertEquals(newFirstNode,testList.getFirstNode());
        assertEquals(nextNode,testList.findNodeByIndex(1));
        assertEquals(nextNode,testList.getLastNode());
    }

    @Test
    void getLastNode() {
        DoublyLinkedNode<Integer> newLastNode = new DoublyLinkedNode<>(10);
        DoublyLinkedNode<Integer> prevNode = new DoublyLinkedNode<>(15);
        prevNode.setNextNode(newLastNode);
        newLastNode.setPreviousNode(prevNode);
        testList.setLastNode(newLastNode);
        assertEquals(newLastNode,testList.getLastNode());
        assertEquals(prevNode,testList.getLastNode().getPreviousNode());
    }

    @Test
    void getLength() {
        assertEquals(integers.length,testList.getLength());
    }

    @Test
    void iterator() {
        int index = 0;
        for(Integer i : testList){
            assertEquals(integers[index++],i);
        }
    }
}