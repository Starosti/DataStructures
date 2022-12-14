package com.starosti.datastructures.linkedlist.doubly;

import com.starosti.datastructures.exceptions.linkedlist.NullNodeException;
import com.starosti.datastructures.linkedlist.LinkedList;
import com.starosti.datastructures.linkedlist.LinkedListIterator;

import java.util.Iterator;
import java.util.Optional;

public class DoublyLinkedList<T> implements LinkedList<T, DoublyLinkedNode<T>> {

    private DoublyLinkedNode<T> firstNode;
    private DoublyLinkedNode<T> lastNode;
    private int length = 0;

    @SafeVarargs
    public DoublyLinkedList(T... elements) {
        this.firstNode = new DoublyLinkedNode<>(elements[0]);
        this.length++;
        DoublyLinkedNode<T> newNode = this.firstNode;
        DoublyLinkedNode<T> previousNode = this.firstNode;
        for (int i = 1; i< elements.length; i++){
            newNode = new DoublyLinkedNode<>(elements[i]);
            previousNode.setNextNode(newNode);
            newNode.setPreviousNode(previousNode);
            this.length++;
            previousNode = newNode;
        }
        this.firstNode.setPreviousNode(null);
        this.lastNode = newNode;
    }

    @Override
    public DoublyLinkedNode<T> findNodeByIndex(int index){
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        int midpoint = length/2;
        DoublyLinkedNode<T> currNode;
        if (index < midpoint){
            currNode = this.firstNode;
            for (int i = 0; i< index; i++){
                currNode = currNode.getNextNode();
            }
        }
        else {
            currNode = this.lastNode;
            for (int i = 0; i < length-index-1; i++){
                currNode = currNode.getPreviousNode();
            }
        }
        return currNode;
    }

    @Override
    public T findDataByIndex(int index){
        return this.findNodeByIndex(index).getData();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<DoublyLinkedNode<T>> findNodeByData(T data){
        return (Optional<DoublyLinkedNode<T>>) findByData(data,this.firstNode.getClass());
    }

    @Override
    public Optional<Integer> findIndexByData(T data){
        return findByData(data,Integer.class);
    }

    @SuppressWarnings("unchecked")
    private <N> Optional<N> findByData(T data, Class<N> clazz){
        // not a very elegant solution, but whatever
        Optional<N> optional = Optional.empty();
        DoublyLinkedNode<T> currNode = this.firstNode;
        int index = -1;
        for(int i = 0; i< this.length; i++){
            if (currNode.getData().equals(data)) {
                index = i;
                break;
            }
            currNode = currNode.getNextNode();
        }

        if (clazz == Integer.class){
            if (index != -1) optional = (Optional<N>) Optional.of(index);
        }

        else {
            if (currNode != null) optional = (Optional<N>) Optional.of(currNode);
        }
        return optional;
    }

    @Override
    public void insertNodeInIndex(DoublyLinkedNode<T> node, int index) {
        if (index > length || index < 0) throw new IndexOutOfBoundsException();
        if (node == null) throw new NullNodeException("Null node while trying to replace doubly linked list node");
        if (index == 0){
            node.setNextNode(firstNode);
            firstNode.setPreviousNode(node);
            this.firstNode = node;
            length++;
            return;
        }
        if (index == length){
            node.setPreviousNode(lastNode);
            lastNode.setNextNode(node);
            this.lastNode = node;
            length++;
            return;
        }
        DoublyLinkedNode<T> prevNode = this.findNodeByIndex(index-1);
        prevNode.getNextNode().setPreviousNode(node);
        node.setNextNode(prevNode.getNextNode());
        node.setPreviousNode(prevNode);
        prevNode.setNextNode(node);
        length++;
    }

    @Override
    public void insertDataInIndex(T data, int index) {
        this.insertNodeInIndex(new DoublyLinkedNode<>(data),index);
    }

    @Override
    public void removeNodeInIndex(int index) {
        if (index >= this.length || index < 0) throw new IndexOutOfBoundsException();
        if (index == 0){
            this.firstNode.getNextNode().setPreviousNode(null);
            this.firstNode = this.firstNode.getNextNode();
            this.length--;
            return;
        }
        if (index == this.length-1){
            this.lastNode.getPreviousNode().setNextNode(null);
            this.lastNode = this.lastNode.getPreviousNode();
            this.length--;
            return;
        }
        DoublyLinkedNode<T> prevNode = this.findNodeByIndex(index-1);
        prevNode.getNextNode().getNextNode().setPreviousNode(prevNode);
        prevNode.setNextNode(prevNode.getNextNode().getNextNode());
        this.length--;
    }

    @Override
    public void replaceDataInIndex(T data, int index) {
        this.findNodeByIndex(index).setData(data);
    }

    @Override
    public void replaceNodeInIndex(DoublyLinkedNode<T> node, int index) {
        if (node == null) throw new NullNodeException("Null node while trying to replace doubly linked list node");
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        DoublyLinkedNode<T> replacedNode = this.findNodeByIndex(index);
        node.setPreviousNode(replacedNode.getPreviousNode()); // 0-1 0
        node.setNextNode(replacedNode.getNextNode()); // 0-1-0

        if (index == 0) this.setFirstNode(node);
        else replacedNode.getPreviousNode().setNextNode(node); // 0=1-0

        if (index == length-1) this.setLastNode(node);
        else replacedNode.getNextNode().setPreviousNode(node); // 0=1=0
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }


    public void setFirstNode(DoublyLinkedNode<T> firstNode) {
        if (firstNode == null) throw new NullNodeException("Null first node in doubly linked list");
        this.firstNode = firstNode;
        this.length = 1;
        DoublyLinkedNode<T> currNode = firstNode;
        while (currNode.getNextNode() != null) {
            this.length++;
            currNode = currNode.getNextNode();
        }
        this.lastNode = currNode;
    }

    public DoublyLinkedNode<T> getFirstNode() {
        return firstNode;
    }

    public void setLastNode(DoublyLinkedNode<T> lastNode) {
        if (lastNode == null) throw new NullNodeException("Null last node in doubly linked list");
        this.lastNode = lastNode;
        this.length = 1;
        DoublyLinkedNode<T> currNode = lastNode;
        while (currNode.getPreviousNode() != null) {
            this.length++;
            currNode = currNode.getPreviousNode();
        }
        this.firstNode = currNode;
    }

    public DoublyLinkedNode<T> getLastNode() {
        return lastNode;
    }

}
