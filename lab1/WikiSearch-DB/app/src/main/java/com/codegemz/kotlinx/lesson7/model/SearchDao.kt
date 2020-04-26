package com.codegemz.kotlinx.lesson7.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface SearchDao {
    @Insert(onConflict = REPLACE)
    fun saveAll(searchEntities: List<SearchEntity>)

    @Query("SELECT * FROM searchentity WHERE queryString = :queryString")
    fun getByQueryString(queryString: String): List<SearchEntity>
}