package com.codegemz.kotlinx.lesson7.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.codegemz.kotlinx.lesson7.base.BaseViewModel
import com.codegemz.kotlinx.lesson7.model.database.AppDatabase
import com.codegemz.kotlinx.lesson7.net.response.SearchItem
import com.codegemz.kotlinx.lesson7.repository.SearchProvider
import com.codegemz.kotlinx.lesson7.repository.SearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchActivityViewModel : BaseViewModel() {
    @Inject
    lateinit var searchRepository: SearchRepository
    @Inject
    lateinit var dataBase: AppDatabase

    internal val searchResponse = MutableLiveData<List<SearchItem>>()

    fun searchRequest(searchString: String) {
        val searchEntities = dataBase.searchDao().getByQueryString(searchString)
        val searchItems = SearchProvider.fromSearchEntities(searchEntities)
        if (!searchItems.isEmpty()) {
            searchResponse.postValue(searchItems)
            return
        }

        val querySearch = searchRepository.querySearch(searchString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    searchResponse.postValue(result.query.search)
                    val searchItems = result.query.search
                    val searchEntities = SearchProvider.fromSearchItems(searchItems, searchString)
                    searchResponse.postValue(searchItems)
                    dataBase.searchDao().saveAll(searchEntities)
                },
                { error ->
                    Log.e(SearchActivityViewModel::class.qualifiedName, error.message)
                }
            )
    }
}
