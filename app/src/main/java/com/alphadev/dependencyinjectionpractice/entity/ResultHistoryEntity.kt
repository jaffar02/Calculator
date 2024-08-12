package com.alphadev.dependencyinjectionpractice.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ResultHistory")
data class ResultHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int=0, val result: String,
    val arg1: String, val arg2: String, val operator: String
)
