package com.github.t1anchen.algs4.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class BagTest {
    val bag: Bag<Int> = Bag()

    @Test
    fun addItemsAndVerify() {
        bag.add(1)
        bag.add(2)
        bag.add(3)
        val expected = listOf(3, 2, 1)
        val actual = bag.asIterable().toList()
        assertEquals(expected, actual)
    }
}