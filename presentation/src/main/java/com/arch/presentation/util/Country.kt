package com.arch.presentation.util

import java.util.TreeMap


class  Country {
    companion object {
        val listCountry : TreeMap<String,String> = mapOf(
            "Argentina" to "ar",
            "Australia" to "au",
            "Austria" to "at",
            "Belgium" to "be",
            "Brazil" to "br",
            "Bulgaria" to "bg",
            "Canada" to "ca",
            "China" to "cn",
            "Colombia" to "co",
            "Cuba" to "cu",
            "Czech Republic" to "cz",
            "Egypt" to "eg",
            "France" to "fr",
            "Germany" to "de",
            "Greece" to "gr",
            "Hong Kong" to "hk",
            "Hungary" to "hu",
            "India" to "in",
            "Indonesia" to "id",
            "Ireland" to "ie",
            "Israel" to "il",
            "Italy" to "it",
            "Japan" to "jp",
            "Latvia" to "lv",
            "Lithuania" to "lt",
            "Malaysia" to "my",
            "Mexico" to "mx",
            "Morocco" to "ma",
            "Netherlands" to "nl",
            "New Zealand" to "nz",
            "Nigeria" to "ng",
            "Norway" to "no",
            "Philippines" to "ph",
            "Poland" to "pl",
            "Portugal" to "pt",
            "Romania" to "ro",
            "Russia" to "ru",
            "Saudi Arabia" to "sa",
            "Serbia" to "rs",
            "Singapore" to "sg",
            "Slovenia" to "si",
            "South Africa" to "za",
            "South Korea" to "kr",
            "Sweden" to "se",
            "Switzerland" to "ch",
            "Taiwan" to "tw",
            "Thailand" to "th",
            "Turkey" to "tr",
            "UAE" to "ae",
            "Ukraine" to "ua",
            "United Kingdom" to "gb",
            "United States" to "us",
            "Venezuela" to "ve"
        ).toSortedMap() as TreeMap<String, String>
    }

}