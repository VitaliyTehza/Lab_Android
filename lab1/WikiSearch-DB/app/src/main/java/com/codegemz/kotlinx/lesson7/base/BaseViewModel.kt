package com.codegemz.kotlinx.lesson7.base

import androidx.lifecycle.ViewModel
import com.codegemz.kotlinx.lesson7.injection.component.DaggerViewModelInjector
import com.codegemz.kotlinx.lesson7.injection.component.ViewModelInjector
import com.codegemz.kotlinx.lesson7.injection.module.AppModule
import com.codegemz.kotlinx.lesson7.search.SearchActivityViewModel

abstract class BaseViewModel : ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(AppModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is SearchActivityViewModel -> injector.inject(this)
        }
    }
}
