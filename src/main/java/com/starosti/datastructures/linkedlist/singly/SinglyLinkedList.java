package com.starosti.datastructures.linkedlist.singly;

import com.starosti.datastructures.exceptions.linkedlist.NullNodeException;
import com.starosti.datastructures.linkedlist.LinkedList;
import com.starosti.datastructures.linkedlist.Node;

import java.util.Optional;

public class SinglyLinkedList<T> implements LinkedList<T, Node<T>> {

    //TODO: implement Iterable

    private Node<T> head;
    private int length = 0;

    @SafeVarargs
    public SinglyLinkedList(T... elements) {
        this.head = new Node<>(elements[0]);
        Node<T> currNode = this.head;
        this.length++;
        for(int i =1; i<elements.length; i++){
            Node<T> newNode = new Node<>(elements[i]);
            currNode.setNextNode(newNode);
            currNode = newNode;
            this.length++;
        }
    }

    @Override
    public Node<T> findNodeByIndex(int index){
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        Node<T> currNode = this.head;
        for(int i = 0; i< index; i++){
            currNode = currNode.getNextNode();
        }
        return currNode;
    }

    public T findDataByIndex(int index){
        return findNodeByIndex(index).getData();
    }

    public Optional<Node<T>> findNodeByData(T data){
        // Duplicated code, but this runs faster so until I find a more elegant solution, I'll keep it
        Node<T> currNode = this.head;
        for(int i = 0; i< this.length; i++){
            if (currNode.getData().equals(data)) return Optional.of(currNode);
            currNode = currNode.getNextNode();
        }
        return Optional.empty();
    }

    public Optional<Integer> findIndexByData(T data){
        // Duplicated code, but this runs faster so until I find a more elegant solution, I'll keep it
        Node<T> currNode = this.head;
        for(int i = 0; i< this.length; i++){
            if (currNode.getData().equals(data)) return Optional.of(i);
            currNode = currNode.getNextNode();
        }
        return Optional.empty();
    }

    public void insertDataInIndex(T data, int index){
        insertNodeInIndex(new Node<>(data),index);
    }

    @Override
    public void insertNodeInIndex(Node<T> node, int index){
        if (node == null) throw new NullNodeException("Null node while trying to insert singly linked list node");
        if (index == 0){
            node.setNextNode(this.head);
            this.head = node;
            this.length++;
            return;
        }
        Node<T> prevNode = findNodeByIndex(index-1);
        node.setNextNode(prevNode.getNextNode());
        prevNode.setNextNode(node);
        this.length++;
    }

    @Override
    public void replaceDataInIndex(T data, int index){
        replaceNodeInIndex(new Node<>(data),index);
    }

    public void replaceNodeInIndex(Node<T> node, int index){
        if (node == null) throw new NullNodeException("Null node while trying to replace singly linked list node");
        if (index == 0){
            node.setNextNode(this.head.getNextNode());
            this.head = node;
            return;
        }
        Node<T> prevNode = findNodeByIndex(index-1);
        node.setNextNode(prevNode.getNextNode().getNextNode());
        prevNode.setNextNode(node);
    }

    @Override
    public void removeNodeInIndex(int index){
        if (index == 0){
            this.head = head.getNextNode();
            this.length--;
            return;
        }
        Node<T> prevNode = findNodeByIndex(index-1);
        prevNode.setNextNode(prevNode.getNextNode().getNextNode());
        this.length--;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void setHead(Node<T> head) {
        if (head == null) throw new NullNodeException("Null head node in singly linked list");
        this.head = head;
        this.length = 1;
        Node<T> currNode = head;
        while (currNode.getNextNode() != null) {
            this.length++;
            currNode = currNode.getNextNode();
        }
    }

    @Override
    public int getLength() {
        return length;
    }
}
