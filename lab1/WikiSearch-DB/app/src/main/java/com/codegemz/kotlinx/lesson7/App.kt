package com.codegemz.kotlinx.lesson7

import android.app.Application
import androidx.multidex.MultiDexApplication

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        lateinit var app: Application
            private set
    }
}
