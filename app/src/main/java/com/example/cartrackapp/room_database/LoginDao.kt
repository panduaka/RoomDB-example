package com.example.cartrackapp.room_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDao {
    @Query("SELECT * FROM LoginDetails")
    fun getAll(): List<UserDB>

    @Insert
    fun insertUser(user: UserDB)

    @Query("SELECT * FROM LoginDetails WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserDB>

//    @Query(
//        "SELECT * FROM user WHERE first_name LIKE :first AND " +
//                "last_name LIKE :last LIMIT 1"
//    )
//    fun findByName(first: String, last: String): UserDB
}