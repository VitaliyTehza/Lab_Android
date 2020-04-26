package com.codegemz.kotlinx.lesson6

import androidx.multidex.MultiDexApplication
import com.codegemz.kotlinx.lesson6.net.RestService
import com.codegemz.kotlinx.lesson6.repository.SearchRepository

class App : MultiDexApplication() {

    companion object {
        val restService by lazy {
            RestService.create()
        }

        var searchRepository = SearchRepository()
    }
}