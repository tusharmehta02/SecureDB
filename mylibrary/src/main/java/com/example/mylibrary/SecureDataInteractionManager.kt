package com.example.mylibrary

interface SecureDataInteractionManager {
    fun addDataSync(pair: Pair<String, String>)
    fun addDataAsync(pair: Pair<String, String>)
    fun getDataAsync(key: String, dataLoadListener: DataLoadListener)
    fun getDataSync(key: String): Pair<String, String?>
    fun closeDB()

}