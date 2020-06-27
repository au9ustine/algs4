package com.github.t1anchen.algs4.v1.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void sort() {
        String[] actual = "INSERTIONSORTEXAMPLE".split("");
        InsertionSort.sort(actual);

        String[] expected = "AEEEIILMNNOOPRRSSTTX".split("");

        assertArrayEquals(expected, actual);
    }
}
