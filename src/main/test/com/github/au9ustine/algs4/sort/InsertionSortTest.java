package com.github.au9ustine.algs4.sort;

import edu.princeton.cs.algs4.Quick;
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
