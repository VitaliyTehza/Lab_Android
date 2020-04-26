package com.codegemz.kotlinx.lesson7.injection.component

import com.codegemz.kotlinx.lesson7.injection.module.AppModule
import com.codegemz.kotlinx.lesson7.search.SearchActivityViewModel
import dagger.Component
import javax.inject.Singleton

/**
* Component providing inject() methods for presenters.
*/
@Singleton
@Component(modules = [(AppModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified SearchActivityViewModel.
     * @param searchActivityViewModel SearchActivityViewModel in which to inject the dependencies
     */
    fun inject(searchActivityViewModel: SearchActivityViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: AppModule): Builder
    }
}
