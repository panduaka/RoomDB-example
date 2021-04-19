package com.example.cartrackapp.room_database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserDB::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun loginDao(): LoginDao
}