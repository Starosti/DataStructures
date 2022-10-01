package com.starosti.datastructures.linkedlist;

public class Node<T>{

    private T data;

    private Node<T> nextNode;

    public Node(T data, Node<T> nextNode) {
        this(data);
        this.nextNode = nextNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
