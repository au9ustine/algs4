package com.github.t1anchen.algs4.v1.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> top;
    private int n;

    public LinkedStack() {
        top = null;
        n = 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void push(T val) {
        Node<T> oldTop = top;
        top = new Node<T>();
        top.val = val;
        top.next = oldTop;
        n++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T topVal = top.val;
        top = top.next;
        n--;
        return topVal;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return top.val;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(top);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T elem : this) {
            builder.append(elem);
            builder.append(' ');
        }
        return builder.toString();
    }

    private static class Node<T> {
        private T val;
        private Node next;
    }

    private class ListIterator<T> implements Iterator<T> {

        private Node<T> current;

        public ListIterator(Node<T> start) {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (isEmpty()) throw new NoSuchElementException();
            T currentVal = current.val;
            current = current.next;
            return currentVal;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}
