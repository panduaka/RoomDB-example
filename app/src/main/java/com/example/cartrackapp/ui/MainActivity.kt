package com.example.cartrackapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.cartrackapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.onGetUsers.postValue(Unit)

        viewModel.run {
            onUsersLoaded.observe(this@MainActivity, Observer {
                    if (it.isNullOrEmpty()) {
                        Log.d("Error", "Error")
                    } else {
                        val x = it
                    }
            })
        }
    }
}