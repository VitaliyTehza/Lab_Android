package com.codegemz.kotlinx.lesson7.model

import com.codegemz.kotlinx.lesson7.net.response.SearchItem

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