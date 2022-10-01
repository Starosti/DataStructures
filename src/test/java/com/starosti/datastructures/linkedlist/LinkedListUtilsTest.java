package com.starosti.datastructures.linkedlist;

import com.starosti.datastructures.linkedlist.singly.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListUtilsTest {

    private SinglyLinkedList<Integer> testList;

    @BeforeEach
    void setUp() {
        testList = new SinglyLinkedList<>(1, 2, 3, 4, 5, 6);
    }

    @Test
    void toArray() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6},LinkedListUtils.toArray(testList,Integer.class));
    }

    @Test
    void testToString() {
        assertEquals("SinglyLinkedList: [1, 2, 3, 4, 5, 6]",LinkedListUtils.toString(testList));
    }

    @Test
    void printList() {

        // https://stackoverflow.com/a/32241101

        PrintStream oldOut = System.out;

        ByteArrayOutputStream testStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testStream));

        LinkedListUtils.printList(testList);

        System.setOut(oldOut);

        @SuppressWarnings("concatenation")
        String expectedOutput =
                "1 in index 0\r\n" +
                "2 in index 1\r\n" +
                "3 in index 2\r\n" +
                "4 in index 3\r\n" +
                "5 in index 4\r\n" +
                "6 in index 5\r\n";

        assertEquals(expectedOutput, testStream.toString());
    }
}