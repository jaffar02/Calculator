package com.alphadev.dependencyinjectionpractice.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alphadev.dependencyinjectionpractice.entity.ResultHistoryEntity

@Database(entities = arrayOf(ResultHistoryEntity::class), version = 1)
abstract class DatabaseImpl: RoomDatabase() {

    abstract fun getDaoObject(): DatabaseInterface

    companion object {
        @Volatile
        private var INSTANCE: DatabaseImpl?= null

        fun getDatabaseObject(context: Context): DatabaseImpl {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    DatabaseImpl::class.java,
                    "res_database")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}