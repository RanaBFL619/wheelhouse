package com.wheelhouse.android

import android.app.Application
import com.wheelhouse.android.di.AndroidModule
import com.wheelhouse.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WheelhouseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WheelhouseApplication)
            modules(sharedKoinModules(this@WheelhouseApplication) + listOf(AndroidModule))
        }
    }
}
