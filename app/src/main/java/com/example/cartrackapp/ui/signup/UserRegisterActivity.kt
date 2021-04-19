package com.example.cartrackapp.ui.signup

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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

            if (inputCheck(userName, password = userPassword, confirmPassword = userConfirmPassword)) {
                viewModel.insertUser(
                    UserDB(
                        0,
                        userName, userPassword, selectedCountry
                    )
                )
            } else {
                Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedCountry = countryArray[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        selectedCountry = countryArray[0]
    }

    private fun inputCheck(userName: String, password: String, confirmPassword: String): Boolean {
        return userName.isNotEmpty() && userName.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()
                && password == confirmPassword

//        return !(TextUtils.isEmpty(userName) && password.isEmpty() && confirmPassword.isEmpty() && password != confirmPassword)
    }
}