package com.github.au9ustine.algs4.sort;

import static org.junit.Assert.*;

public class QuickSortTest {

    @org.junit.Test
    public void sort() {
        String[] actual = "QUICKSORTEXAMPLE".split("");
        QuickSort.sort(actual);
        String[] expected = "ACEEIKLMOPQRSTUX".split("");
        assertArrayEquals(expected, actual);
    }
}
