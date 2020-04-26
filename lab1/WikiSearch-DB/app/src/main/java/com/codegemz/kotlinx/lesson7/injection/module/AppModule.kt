package com.codegemz.kotlinx.lesson7.injection.module

import androidx.room.Room
import com.codegemz.kotlinx.lesson7.App
import com.codegemz.kotlinx.lesson7.BASE_URL
import com.codegemz.kotlinx.lesson7.model.database.AppDatabase
import com.codegemz.kotlinx.lesson7.net.Api
import com.codegemz.kotlinx.lesson7.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Module which provides all required dependencies about network, database, etc
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object AppModule {
    /**
     * Provides the Post service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Post service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    /**
     * Provides the SearchRepository object.
     * @return the SearchRepository object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideSearchRepository(api: Api): SearchRepository {
        return SearchRepository(api)
    }
    /**
     * Provides the AppDatabase object.
     * @return the AppDatabase object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(App.app, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}
