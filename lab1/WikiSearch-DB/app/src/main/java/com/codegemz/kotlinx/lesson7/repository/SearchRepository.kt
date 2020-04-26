package com.codegemz.kotlinx.lesson7.repository

import com.codegemz.kotlinx.lesson7.model.SearchModel
import com.codegemz.kotlinx.lesson7.net.Api
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

open class SearchRepository(var api: Api) {

    open fun querySearch(searchString: String): Observable<SearchModel.Search> {
        return api.querySearch("query", "json", "search", searchString)
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
