package com.codegemz.kotlinx.lesson7.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codegemz.kotlinx.lesson7.model.SearchDao
import com.codegemz.kotlinx.lesson7.model.SearchEntity

@Database(entities = [SearchEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}
