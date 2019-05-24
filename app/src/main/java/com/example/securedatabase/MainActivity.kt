package com.example.securedatabase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mylibrary.DBHelper
import com.example.mylibrary.DataLoadListener
import com.example.mylibrary.SecureDataInteractionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DataLoadListener {

    lateinit var secureDataInteractionManager:  SecureDataInteractionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        secureDataInteractionManager = DBHelper.getInstance(this, stringFromJNIClass())
        val pair  = secureDataInteractionManager.getDataSync("13")
        tvKey.text = "Key: "+ pair.first
        tvValue.text = "Value: "+ pair.second
    }



    external fun stringFromJNIClass(): String


    override fun onDataLoaded(pair: Pair<String, String?>) {
       Log.d(TAG, pair.first +"  "+ pair.second)
    }


    override fun onDestroy() {
        super.onDestroy()
        secureDataInteractionManager.closeDB()
    }

    companion object {
        val TAG = MainActivity.javaClass.simpleName
    }
}
