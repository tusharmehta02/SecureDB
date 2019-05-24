package com.example.securedatabase

import android.app.Application
import com.example.mylibrary.SecuredDataManager

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SecuredDataManager.install(this)
    }
}
