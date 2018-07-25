package com.github.au9ustine.algs4.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void search() {
        String[] input = {"a", "b", "c", "d", "e"};
        int actual = BinarySearch.search(input, "c");
        int expected = 2;
        assertEquals(expected, actual);
        actual = BinarySearch.search(input, "f");
        assertEquals(-1, actual);
    }
}
