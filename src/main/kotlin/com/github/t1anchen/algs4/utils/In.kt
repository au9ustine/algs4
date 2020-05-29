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

    // [2020-05-29T17:04:36+0800] 今天发现，所谓的允许空类型其功能上就是 java 8 中的
    // Optional，所以有人喷 Kotlin 没有 Maybe ([1][2]) 我觉得是不是他们对 Kotlin 不
    // 了解造成的呢？
    //
    // [1] https://cloud.tencent.com/developer/news/249347
    // [2] https://allegro.tech/2018/05/From-Java-to-Kotlin-and-Back-Again.html
    constructor(stream: BufferedInputStream?) {
        when (stream) {
            null -> throw IllegalArgumentException("file is null")
            else -> try {
                scanner = Scanner(stream.bufferedReader())
                scanner.useLocale(LOCALE)
            } catch (ioe: IOException) {
                throw IllegalArgumentException("Could not open $stream", ioe)
            }
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
