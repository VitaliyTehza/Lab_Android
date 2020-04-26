package com.codegemz.kotlinx.lesson7.net

import com.codegemz.kotlinx.lesson7.model.SearchModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("api.php")
    fun querySearch(@Query("action") action: String,
                    @Query("format") format: String,
                    @Query("list") list: String,
                    @Query("srsearch") srsearch: String): Observable<SearchModel.Search>
}
