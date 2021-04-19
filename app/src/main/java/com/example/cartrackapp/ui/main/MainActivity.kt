package com.example.cartrackapp.ui.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartrackapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()
    private val adapter = UserAdapter {
        val uri: String = java.lang.String.format(Locale.ENGLISH, "geo:%f,%f", it.lat, it.lng)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)
        userRecyclerView.adapter = adapter

        viewModel.onGetUsers.postValue(Unit)

        viewModel.run {
            onUsersLoaded.observe(this@MainActivity, Observer {
                if (it.isNullOrEmpty()) {
                    Toast.makeText(this@MainActivity, "No Users Available", Toast.LENGTH_LONG).show()
                } else {
                    adapter.usersList = it
                    adapter.notifyDataSetChanged()
                }
            })
        }
    }
}