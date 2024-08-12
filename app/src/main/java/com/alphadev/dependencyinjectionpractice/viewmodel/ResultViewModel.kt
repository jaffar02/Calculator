package com.alphadev.dependencyinjectionpractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphadev.dependencyinjectionpractice.entity.ResultHistoryEntity
import com.alphadev.dependencyinjectionpractice.repository.ResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel(val repository: ResultRepository): ViewModel() {

    val allHistory = repository.getAllHistory()

    fun insert(res: ResultHistoryEntity) {
        viewModelScope.launch(Dispatchers.Main) {
            repository.insert(res)
        }
    }

    fun update(res: ResultHistoryEntity) {
        viewModelScope.launch(Dispatchers.Main) {
            repository.update(res)
        }
    }

    fun delete(res: ResultHistoryEntity) {
        viewModelScope.launch(Dispatchers.Main) {
            repository.delete(res)
        }
    }
}