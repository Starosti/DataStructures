package com.starosti.datastructures.linkedlist;

import java.util.Optional;

public interface LinkedList<T,N extends Node<T>> extends Iterable<T> {

    int getLength();

    N findNodeByIndex(int index);
    T findDataByIndex(int index);
    Optional<N> findNodeByData(T data);
    Optional<Integer> findIndexByData(T data);

    void insertNodeInIndex(N node, int index);
    void insertDataInIndex(T data, int index);

    void removeNodeInIndex(int index);

    void replaceDataInIndex(T data, int index);
    void replaceNodeInIndex(N node, int index);
}
