package com.example.cartrackapp.room_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cartrackapp.clean_architecture.Response


@Dao
interface UserDao {
    @Query("SELECT * FROM LoginDetails")
    fun getAll(): List<UserDB>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: UserDB)

    @Query("SELECT * FROM LoginDetails WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserDB>
}