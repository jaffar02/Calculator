package com.alphadev.dependencyinjectionpractice.di

import com.alphadev.dependencyinjectionpractice.data.DatabaseImpl
import com.alphadev.dependencyinjectionpractice.repository.ResultRepository
import com.alphadev.dependencyinjectionpractice.viewmodel.ResultViewModel
import com.alphadev.dependencyinjectionpractice.viewmodel.ResultViewModelFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

public val appModule = module {
    factory {
        ResultRepository(DatabaseImpl.getDatabaseObject(androidContext()))
    }

    viewModel() {
        ResultViewModelFactory(get()).create(ResultViewModel::class.java)
    }


}