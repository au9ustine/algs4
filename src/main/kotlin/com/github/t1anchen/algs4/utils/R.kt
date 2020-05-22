package com.github.t1anchen.algs4.utils

import java.util.*

object R {
    // [2020-05-22T22:36:16+0800] 本来想使用在 Android 开发中类似的 R.string.xxx 的方
    // 式使用，但是在应用 xml 的时候，ResourceBundle.getBundle 始终无法认出 xml 类型的
    // ResourceBundle 文件，只能认出 .properties 的形式。在 github 上有人给出了一个使用
    // ResourceBundle XML 文件的例子（https://gist.github.com/asicfr/1b76ea60029264d7be15d019a866e1a4）
    // 但是从这个例子中可以看出，这个样例思路是通过重新构建一个基于 ResourceBundle 的类
    // （XMLResourceBundle）并重写其中的方法。因这个思路可行但是烦琐，不符合关于复杂性方面
    // 奥卡姆剃刀法则，因而临时只采用 properties 的形式。另外，ResourceBundle 方面的有效资
    // 料极少，而垃圾消息很多，大部分垃圾消息甚至就是互相抄袭，所以在筛选资料上浪费了很多时间，
    // 这使我很痛心，也决心自己必须珍惜每一刻时间，不要浪费在无谓的做工上。
    //
    // 所以，越是底层透明的语言，越是简单的语言，就越容易调试，也越容易实现自己的价值。
    fun str(k: String): String =
            ResourceBundle.getBundle("strings").getString(k)
    fun str(k: String, locale: Locale) =
            ResourceBundle.getBundle("strings", locale).getString(k)
}

