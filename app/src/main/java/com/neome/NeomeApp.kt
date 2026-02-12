package com.neome

import android.app.Application
import com.neome.core.logging.LoggingInitializer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NeomeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LoggingInitializer.init(this)
    }
}
