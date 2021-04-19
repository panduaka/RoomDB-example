package com.example.cartrackapp.data.mapper

import com.example.cartrackapp.data.model.DataUser
import com.example.cartrackapp.domain.model.AddressDomain
import com.example.cartrackapp.domain.model.CompanyDomain
import com.example.cartrackapp.domain.model.GeoDomain
import com.example.cartrackapp.domain.model.UserDomain

fun getUsers(users: List<DataUser>?): List<UserDomain>? {
    val userDomainList = mutableListOf<UserDomain>()

    users?.forEach {
        val address = it.address
        val geo = address.geo
        val company = it.company

        val addressDomain = AddressDomain(
            street = address.street,
            suite = address.suite,
            city = address.city,
            zipcode = address.zipcode,
            geo = GeoDomain(
                lat = geo.lat,
                lng = geo.lng
            )
        )

        val companyDomain = CompanyDomain(
            name = company.name,
            catchPhrase = company.catchPhrase,
            bs = company.bs
        )

        val userDomain = UserDomain(
            id = it.id,
            name = it.name,
            username = it.username,
            email = it.email,
            phone = it.phone,
            website = it.website,
            address = addressDomain,
            company = companyDomain
        )

        userDomainList.add(userDomain)
    }

    return userDomainList
}


