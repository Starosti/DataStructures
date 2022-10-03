package com.starosti.datastructures.linkedlist.singly;

import com.starosti.datastructures.linkedlist.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> testList;
    private final Integer[] integers = {1, 2, 3, 4, 5, 6};
    private final Integer[] notIntegers = {7, 8, 9, 10, 11};

    @BeforeEach
    void setUp() {
        testList = new SinglyLinkedList<>(integers);
    }

    @Test
    void findNodeByIndex() {
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for(int i = 0; i< integers.length; i++){
            assertEquals(currNode,testList.findNodeByIndex(i));
            assertEquals(integers[i],testList.findNodeByIndex(i).getData());
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void findDataByIndex() {
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for(int i = 0; i< integers.length; i++){
            assertEquals(integers[i],testList.findDataByIndex(i));
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void findNodeByData() {
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : integers) {
            assertEquals(currNode, testList.findNodeByData(integer).orElseThrow());
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void checkNotFoundFindNodeByData(){
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer notInteger : notIntegers) {
            assertFalse(testList.findNodeByData(notInteger).isPresent());
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void findIndexByData() {
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for(int i = 0; i< integers.length; i++){
            assertEquals(i,testList.findIndexByData(integers[i]).orElseThrow());
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void checkNotFoundFindIndexByData(){
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer notInteger : notIntegers) {
            assertFalse(testList.findIndexByData(notInteger).isPresent());
            currNode = currNode.getNextNode();
        }
    }

    @Test
    void insertDataInIndex() {
                                                     //     1, 2,    3, 4, 5, 6
        testList.insertDataInIndex(5,2);  //     1, 2, 5, 3, 4, 5, 6
        testList.insertDataInIndex(10,0); // 10, 1, 2, 5, 3, 4, 5, 6
        testList.insertDataInIndex(15,8); // 10, 1, 2, 5, 3, 4, 5, 6, 15
        Integer[] expected = {10, 1, 2, 5, 3, 4, 5, 6, 15};
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertNull(currNode);
    }

    @Test
    void insertNodeInIndex() {
                                                                   //     1, 2,    3, 4, 5, 6
        testList.insertNodeInIndex(new Node<>(5),2);    //     1, 2, 5, 3, 4, 5, 6
        testList.insertNodeInIndex(new Node<>(10),0);   // 10, 1, 2, 5, 3, 4, 5, 6
        testList.insertNodeInIndex(new Node<>(15),8);   // 10, 1, 2, 5, 3, 4, 5, 6, 15
        Integer[] expected = {10, 1, 2, 5, 3, 4, 5, 6, 15};
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertNull(currNode);
    }

    @Test
    void replaceDataInIndex() {
                                                        // 1, 2, 3, 4, 5, 6
        testList.replaceDataInIndex(5,2);    // 1, 2, -5-, 4, 5, 6
        testList.replaceDataInIndex(10,0);   // -10-, 2, 5, 4, 5, 6
        testList.replaceDataInIndex(15,5);   // 10, 2, 5, 4, 5, -15-
        Integer[] expected = {10, 2, 5, 4, 5, 15};
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertNull(currNode);
    }

    @Test
    void replaceNodeInIndex() {
                                                                    // 1, 2, 3, 4, 5, 6
        testList.replaceNodeInIndex(new Node<>(5),2);    // 1, 2, -5-, 4, 5, 6
        testList.replaceNodeInIndex(new Node<>(10),0);   // -10-, 2, 5, 4, 5, 6
        testList.replaceNodeInIndex(new Node<>(15),5);   // 10, 2, 5, 4, 5, -15-
        Integer[] expected = {10, 2, 5, 4, 5, 15};
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertNull(currNode);
    }

    @Test
    void removeNodeInIndex() {
                                         // 1, 2, 3, 4, 5, 6
        testList.removeNodeInIndex(5);   // 1, 2, 3, 4, 5, _6_ -> 1, 2, 3, 4, 5
        testList.removeNodeInIndex(2);   // 1, 2, _3_, 4, 5,   -> 1, 2, 4, 5,
        testList.removeNodeInIndex(0);   // _1_, 2, 4, 5,      -> 2, 4, 5,
        Integer[] expected = {2, 4, 5};
        Node<Integer> currNode = testList.findNodeByIndex(0);
        for (Integer integer : expected) {
            assertEquals(integer, currNode.getData());
            currNode = currNode.getNextNode();
        }
        assertNull(currNode);
    }

    @Test
    void getHead() {
        assertEquals(integers[0],testList.getHead().getData());
        assertNotNull(testList.getHead().getNextNode());
    }

    @Test
    void setHead() {
        Node<Integer> newHeadNode = new Node<>(10);
        Node<Integer> nextNode = new Node<>(15);
        newHeadNode.setNextNode(nextNode);
        testList.setHead(newHeadNode);
        assertEquals(newHeadNode,testList.getHead());
        assertEquals(nextNode,testList.findNodeByIndex(1));
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