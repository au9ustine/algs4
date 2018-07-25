package com.github.au9ustine.algs4.search;

public class BinarySearch {
    public static int search(Comparable[] a, Comparable key) {
        int lo = 0, hi = a.length-1;
        while(lo <= hi) {
            int mid = (hi + lo) >>> 1;
            if (key.compareTo(a[mid]) > 0) hi = mid - 1;
            else if (key.compareTo(a[mid]) < 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
