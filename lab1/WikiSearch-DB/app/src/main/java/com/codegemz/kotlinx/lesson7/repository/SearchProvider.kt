package com.codegemz.kotlinx.lesson7.repository

import com.codegemz.kotlinx.lesson7.model.SearchEntity
import com.codegemz.kotlinx.lesson7.net.response.SearchItem
import java.util.ArrayList

class SearchProvider {

    companion object {
        fun fromSearchEntities(searchEntities: List<SearchEntity>): List<SearchItem> {
            val searchItems = ArrayList<SearchItem>(searchEntities.size)
            searchEntities.forEach {
                val searchItem = SearchItem(
                    it.title,
                    it.pageid,
                    it.snippet
                )
                searchItems.add(searchItem)
            }
            return searchItems
        }

        fun fromSearchItems(searchItems: List<SearchItem>, searchString: String): List<SearchEntity> {
            val searchEntities = ArrayList<SearchEntity>(searchItems.size)
            searchItems.forEach {
                val searchEntity = SearchEntity(
                    null,
                    it.title,
                    it.pageid,
                    it.snippet,
                    searchString
                )
                searchEntities.add(searchEntity)
            }
            return searchEntities
        }
    }
}
