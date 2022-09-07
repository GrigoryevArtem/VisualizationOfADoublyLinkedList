package com.company;

public class Node<T> {
    public T data;
    public Node next;
    public Node previous;

    public Node(T data) {
        this.data = data;
    }
}
