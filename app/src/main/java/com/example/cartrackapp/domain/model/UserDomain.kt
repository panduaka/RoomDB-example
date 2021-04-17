package com.example.cartrackapp.domain.model

import com.google.gson.annotations.SerializedName

data class UserDomain(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressDomain,
    val phone: String,
    val website: String,
    val company: CompanyDomain
)

data class CompanyDomain(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class AddressDomain(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoDomain
)

data class GeoDomain(
    val lat: Double,
    val lng: Double
)