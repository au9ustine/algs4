package com.github.t1anchen.algs4.v1.sort;

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
