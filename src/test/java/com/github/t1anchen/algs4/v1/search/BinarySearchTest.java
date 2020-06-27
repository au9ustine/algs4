package com.github.t1anchen.algs4.v1.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void search() {
        String[] input = "abcdefghijklmnopqrstuvwxyz".split("");
        int actual = BinarySearch.search(input, "w");
        int expected = 22;
        assertEquals(expected, actual);
        actual = BinarySearch.search(input, "0");
        assertEquals(-1, actual);
    }


    @Test
    public void testExceptionalSearch() {
        String[] input = "abcdefghijklmnopqrstuvwxyz".split("");
        shuffle(input);
        int actual = BinarySearch.search(input, "w");
        int expected = 22;
        assertEquals(expected, actual);
    }

    private static void shuffle(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int)(Math.random() * (n-i));
            swap(a, r, i);
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
