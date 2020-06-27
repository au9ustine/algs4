package com.github.t1anchen.algs4.v1.search;

import java.util.Arrays;

public class BinarySearch {
    public static int search(Comparable[] a, Comparable key, boolean sorted) {
        assert sorted;
        int lo = 0, hi = a.length-1;
        while(lo <= hi) {
            int mid = (hi + lo) >>> 1;
            if (a[mid].compareTo(key) > 0) hi = mid - 1;
            else if (a[mid].compareTo(key) < 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int search(Comparable[] a, Comparable key) {
        Arrays.sort(a);
        return search(a, key, true);
    }
}
