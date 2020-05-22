package com.github.t1anchen.algs4.utils

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RTest {

    @Test
    fun testStr() {
        val expected = "Number of vertices must be nonnegative"
        val actual = R.str("errmsg.graph.negative_vertice")
        assertEquals(expected, actual)
    }

    @Test
    fun testStrCn() {
        val expected = "定点数量必须为非负整数"
        val actual = R.str("errmsg.graph.negative_vertice", Locale.CHINA)
        assertEquals(expected, actual)
    }
}
