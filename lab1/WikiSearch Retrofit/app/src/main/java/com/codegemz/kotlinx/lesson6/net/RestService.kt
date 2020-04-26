package com.codegemz.kotlinx.lesson6.net

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RestService {

    companion object {
        fun create(): RestService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RestService::class.java)
        }
    }

    @GET("api.php")
    fun querySearch(@Query("action") action: String,
                    @Query("format") format: String,
                    @Query("list") list: String,
                    @Query("srsearch") srsearch: String): Observable<SearchModel.Search>
}
