package com.codegemz.kotlinx.lesson6.repository

import com.codegemz.kotlinx.lesson6.App
import com.codegemz.kotlinx.lesson6.net.SearchModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

open class SearchRepository {
    private val restService = App.restService

    open fun querySearch(searchString: String): Observable<SearchModel.Search> {
        return restService.querySearch("query", "json", "search", searchString)
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
