package com.alphadev.dependencyinjectionpractice.repository

import com.alphadev.dependencyinjectionpractice.data.DatabaseImpl
import com.alphadev.dependencyinjectionpractice.data.DatabaseInterface
import com.alphadev.dependencyinjectionpractice.entity.ResultHistoryEntity

class ResultRepository(private val database: DatabaseImpl) {

    suspend fun insert(res: ResultHistoryEntity) {
        database.getDaoObject().insert(res)
    }

    suspend fun update(res: ResultHistoryEntity) {
        database.getDaoObject().update(res)
    }

    suspend fun delete(res: ResultHistoryEntity) {
        database.getDaoObject().delete(res)
    }

    fun getAllHistory() = database.getDaoObject().getAllHistory()
}