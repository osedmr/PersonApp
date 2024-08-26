package com.example.personsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.personsapp.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getKisilerDao(): KisilerDao
}