package com.github.au9ustine.algs4.basic;

import java.util.Iterator;

public interface Stack<T> extends Iterable<T> {
    int size();

    void push(T val);

    T pop();

    T peek();

    boolean isEmpty();

    @Override
    Iterator<T> iterator();
}
