package com.codegemz.kotlinx.lesson6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.codegemz.kotlinx.lesson6.net.response.SearchItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel : ViewModel() {
    private val searchRepository = App.searchRepository
    internal val searchResponse = MutableLiveData<List<SearchItem>>()

    fun searchRequest(searchString: String) {
        val querySearch = searchRepository.querySearch(searchString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    searchResponse.postValue(result.query.search)
                },
                { error ->
                    Log.e(MainActivityViewModel::class.qualifiedName, error.message)
                }
            )
    }
}
