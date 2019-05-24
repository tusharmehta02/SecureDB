package com.example.mylibrary

import android.content.Context
import android.content.pm.ApplicationInfo
import android.util.Log
import net.sqlcipher.database.SQLiteDatabase

object SecuredDataManager {

    init {
        System.loadLibrary("native-lib")
    }

    fun install(context: Context) {
        SQLiteDatabase.loadLibs(context)
    }

}