package com.example.cartrackapp.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.cartrackapp.R
import com.example.cartrackapp.room_database.UserDB
import kotlinx.android.synthetic.main.user_register_activity_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserRegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val viewModel by viewModel<UserRegisterViewModel>()
    private lateinit var countryArray: Array<String>
    private lateinit var selectedCountry: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_register_activity_layout)

        countrySpinner.onItemSelectedListener = this
        countryArray = resources.getStringArray(R.array.country_array)

        ArrayAdapter.createFromResource(
            this,
            R.array.country_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            countrySpinner.adapter = adapter
        }

        userRegisterButton.setOnClickListener {
            val userName = userRegisterNameTextview.text.toString()
            val userPassword = userRegisterPasswordTextview.text.toString()
            val userConfirmPassword = userRegisterPasswordConfirmationTextview.text.toString()

            viewModel.insertUser(
                UserDB(
                    0,
                    userName, userPassword, selectedCountry
                )
            )
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedCountry = countryArray[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        selectedCountry = countryArray[0]
    }
}