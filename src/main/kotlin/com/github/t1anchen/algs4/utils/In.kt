package com.github.t1anchen.algs4.utils

import java.io.BufferedInputStream
import java.io.IOException
import java.net.URL
import java.net.URLConnection
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

    constructor(name: String?) {
        if (name == null) throw IllegalArgumentException("argument is null")
        try {
            val file = Paths.get(name).toFile()
            if (file.exists()) {
                scanner = Scanner(file.bufferedReader())
                scanner.useLocale(LOCALE)
                return
            }

            var url = javaClass.getResource(name)
            if (url == null) {
                url = javaClass.classLoader.getResource(name)
            }

            if (url == null) {
                url = URL(name)
            }

            val site: URLConnection = url.openConnection();
            val stream = site.getInputStream()
            scanner = Scanner(stream.buffered())
            scanner.useLocale(LOCALE)
        } catch (ioe: IOException) {
            throw java.lang.IllegalArgumentException("could not open $name", ioe)
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
