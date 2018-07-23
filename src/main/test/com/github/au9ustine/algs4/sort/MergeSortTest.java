package com.github.au9ustine.algs4.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sort() {
        String[] actual = "MERGESORTEXAMPLE".split("");
        MergeSort.sort(actual);

        String[] expected = "AEEEEGLMMOPRRSTX".split("");

        assertArrayEquals(expected, actual);
    }
}
