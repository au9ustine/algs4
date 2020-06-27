package com.github.t1anchen.algs4.v1.sort;

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
