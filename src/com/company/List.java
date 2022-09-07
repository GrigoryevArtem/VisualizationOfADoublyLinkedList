package com.company;

import javax.swing.*;

public class List<T> {
    private int size;
    private Node head;
    private Node tail;

    public List() {
        size = 0;
        head = null;
        tail = null;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
    public Node getHead(){return head;}
    public Node getTail(){return tail;}

    public void insertFirst(T value) {

        Node newNode = new Node(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void insertLast(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        size++;


    }

    public Node deleteFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Ошибка!Двусвязный список пуст!");
        } else {
            Node temp = head;
            if (head.next == null)
                tail = null;
            else
                head.next.previous = null;
                head = head.next;

            size--;
            return temp;
        }
    }

    public Node deleteLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Ошибка!Двусвязный список пуст!");
        } else {
            Node temp = tail;
            if (head.next == null)
                head = null;
            else
                tail.previous.next = null;
                tail = tail.previous;

            size--;
            return temp;

        }
    }

    public void insertIndex(int index, T value) {

        if (index <=size && index >= 0) {
            if (index == 0) {
                insertFirst(value);
            } else if (index == size) {
                insertLast(value);
            } else if (index <= size / 2) {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }

                Node newNode = new Node(value);

                current.next.previous = newNode;
                newNode.next = current.next;
                current.next = newNode;
                newNode.previous = current;
                size++;
            } else if (index > size / 2) {
                Node current = tail;
                for (int i = size - 1; i > index + 1; i--) {
                    current = current.previous;
                }

                Node newNode = new Node(value);

                current.previous.next = newNode;
                newNode.previous = current.previous;
                current.previous = newNode;
                newNode.next = current;
                size++;
            }
        } else
            throw new IndexOutOfBoundsException("Ошибка!Выход за пределы списка!Данного индекса нет в двусвязном списке!");
    }

    public void deleteIndex(int index) {

        if (index < size && index >= 0) {

            if (index == 0)
                deleteFirst();
            else if (index == size - 1)
                deleteLast();
            else if (index <= size / 2) {

                Node current = head;
                for (int i = 0; i < index - 1; i++) {

                    current = current.next;
                }
                current.next.next.previous = current;
                current.next = current.next.next;
                size--;
            } else if (index > size / 2) {
                Node current = tail;
                for (int i = size - 1; i > index + 1; i--) {
                    current = current.previous;

                }
                current.previous.previous.next = current;
                current.previous = current.previous.previous;
                size--;

            }
        } else
            throw new IndexOutOfBoundsException("Ошибка!Выход за пределы списка!Данного индекса нет в двусвязном списке!");
    }







    public Node search(int index) {
        Node temp;
        if (index <= size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            return temp;
        } else if (index > size / 2) {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
            return temp;
        }
        return null;
    }

    public void clear()
    {
        while (size!=0) deleteLast();

    }
    public void deleteKey(T key){
        Node current=head;
        while (current!=null)
        {
            if(current.data==key)
            {
                if(current==head)
                    deleteFirst();
                else if(current==tail)
                    deleteLast();
                else{

                    current.next.previous=current.previous;
                    current.previous.next=current.next;
                }

            }
            current=current.next;
        }

    }
    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
    }

}
