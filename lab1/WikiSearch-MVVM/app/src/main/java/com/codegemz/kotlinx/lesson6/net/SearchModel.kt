package com.codegemz.kotlinx.lesson6.net

import com.codegemz.kotlinx.lesson6.net.response.SearchItem

object SearchModel {
    data class Search(
        val query: Query
    )

    data class Query(
        val searchinfo: SearchInfo,
        val search: List<SearchItem>
    )

    data class SearchInfo(
        val totalhits: Int
    )
}