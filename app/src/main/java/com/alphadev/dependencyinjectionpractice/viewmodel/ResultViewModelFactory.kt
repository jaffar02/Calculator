package com.alphadev.dependencyinjectionpractice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alphadev.dependencyinjectionpractice.repository.ResultRepository

class ResultViewModelFactory(val repository: ResultRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ResultViewModel(repository) as T
    }
}