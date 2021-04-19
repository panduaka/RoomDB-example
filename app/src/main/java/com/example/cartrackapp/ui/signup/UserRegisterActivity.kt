package com.example.cartrackapp.ui.signup

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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

        viewModel.run {
            onUserRegistered.observe(this@UserRegisterActivity, Observer {
                if (it) {
                    Toast.makeText(this@UserRegisterActivity, "User Added Successfully", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@UserRegisterActivity, "An Error Occurred", Toast.LENGTH_LONG).show()
                }
            })
        }

        userRegisterButton.setOnClickListener {
            val userName = userRegisterNameTextview.text.toString()
            val userPassword = userRegisterPasswordTextview.text.toString()
            val userConfirmPassword = userRegisterPasswordConfirmationTextview.text.toString()

            if (inputCheck(userName, password = userPassword, confirmPassword = userConfirmPassword)) {
                viewModel.onUserRegister.postValue(
                    UserDB(
                        0,
                        userName, userPassword, selectedCountry
                    )
                )
            } else {
                Toast.makeText(this@UserRegisterActivity, "Please fill out all fields.", Toast.LENGTH_LONG).show()
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
    }
}