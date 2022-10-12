package com.starosti.datastructures.linkedlist.doubly;

import com.starosti.datastructures.linkedlist.Node;

public class DoublyLinkedNode<T> extends Node<T> {

    private DoublyLinkedNode<T> previousNode;

    private DoublyLinkedNode<T> nextNode;

    public DoublyLinkedNode(T data) {
        super(data);
    }

    public DoublyLinkedNode(T data, DoublyLinkedNode<T> nextNode) {
        this(data);
        this.nextNode = nextNode;
    }

    public DoublyLinkedNode(T data, DoublyLinkedNode<T> nextNode, DoublyLinkedNode<T> previousNode) {
        this(data,nextNode);
        this.previousNode = previousNode;
    }

    public DoublyLinkedNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyLinkedNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public DoublyLinkedNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
