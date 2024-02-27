package com.example.android.marsphotos

import android.app.Application
import com.example.android.marsphotos.data.AppContainer
import com.example.android.marsphotos.data.DefaultAppContainer

class MarsPhotosApplication : Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}