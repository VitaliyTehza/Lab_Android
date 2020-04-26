package com.codegemz.kotlinx.lesson6.net.response

data class SearchItem(
    val title: String,
    val pageid: Long,
    val snippet: String
)