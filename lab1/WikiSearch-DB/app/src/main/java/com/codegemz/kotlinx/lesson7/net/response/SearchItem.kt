package com.codegemz.kotlinx.lesson7.net.response

data class SearchItem(
    val title: String,
    val pageid: Long,
    val snippet: String
)
