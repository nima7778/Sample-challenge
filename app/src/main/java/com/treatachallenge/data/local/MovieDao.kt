package com.treatachallenge.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieEntity: MovieEntity)

    @Query("DELETE FROM favorites WHERE content_id=:contentId")
    suspend fun remove (contentId: Long)

    @Query("SELECT *  FROM favorites")
    fun getAll(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM favorites WHERE content_id=:contentId")
    fun getSpecificMovie (contentId: Long): Flow<MovieEntity>
}