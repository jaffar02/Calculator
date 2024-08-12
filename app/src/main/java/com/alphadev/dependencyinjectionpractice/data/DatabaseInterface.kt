package com.alphadev.dependencyinjectionpractice.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.alphadev.dependencyinjectionpractice.entity.ResultHistoryEntity

@Dao
interface DatabaseInterface {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(res: ResultHistoryEntity)

    @Update
    suspend fun update(res: ResultHistoryEntity)

    @Delete
    suspend fun delete(res: ResultHistoryEntity)

    @Query("select * from ResultHistory")
    fun getAllHistory(): LiveData<List<ResultHistoryEntity>>

}