package com.alphadev.dependencyinjectionpractice.ui.activities

import android.app.Application
import com.alphadev.dependencyinjectionpractice.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationClass: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationClass)
            modules(listOf(appModule))
        }
    }
}