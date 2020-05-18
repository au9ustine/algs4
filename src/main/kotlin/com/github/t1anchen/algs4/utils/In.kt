package com.github.t1anchen.algs4.utils

import java.io.BufferedInputStream
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import kotlin.NoSuchElementException

class In {
    val LOCALE = Locale.US
    private val scanner: Scanner

    constructor(stream: BufferedInputStream?) {
        if (stream == null) throw IllegalArgumentException("file is null")
        try {
            scanner = Scanner(stream.bufferedReader())
            scanner.useLocale(LOCALE)
        } catch (ioe: IOException) {
            throw IllegalArgumentException("Could not open $stream", ioe)
        }
    }

    fun readInt(): Int {
        try {
            return scanner.nextInt()
        } catch (e: InputMismatchException) {
            val token: String = scanner.next()
            throw InputMismatchException("""attempts to read an 'int' value from the input stream, but the next token is "$token" """)
        } catch (e: NoSuchElementException) {
            throw NoSuchElementException("""attemps to read an 'int' value from the input stream, but no more tokens are available""")
        }
    }
}
