package com.arch.presentation.util

import java.util.TreeMap

class Language {
    companion object {
        const val ALL = "all"
        var flag: String = ALL
        fun isSelectLang(lang : String) : Boolean = lang == flag

        val listLanguage: TreeMap<String, String> = mapOf(
            "All" to "all",
            "English" to "en",
            "Russian" to "ru",
            "Argentina" to "ar",
            "Germany" to "de",
            "Spanish" to "es",
            "France" to "fr",
            "Ukraine" to "ua"
        ).toSortedMap() as TreeMap<String, String>

    }
}