package com.example.cartrackapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cartrackapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val x = viewModel.getUsers()

    }
}