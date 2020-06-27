package com.github.t1anchen.algs4.utils

import java.lang.IllegalArgumentException

object Err {
    fun nonNegative(obj: Any): Exception = throw IllegalArgumentException(
            "$obj must be non-negative"
    )

    fun between(obj: Int, lower: Int, upper: Int): Exception =
            throw IllegalArgumentException(
                    "$obj is not between $lower and $upper"
            )
}
