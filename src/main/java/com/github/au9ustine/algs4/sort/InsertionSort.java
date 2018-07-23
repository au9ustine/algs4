package com.github.au9ustine.algs4.sort;

public class InsertionSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
