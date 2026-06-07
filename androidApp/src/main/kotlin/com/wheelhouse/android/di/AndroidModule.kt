package com.wheelhouse.android.di

import com.wheelhouse.android.viewmodel.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val AndroidModule = module {
    viewModel { AuthViewModel(get()) }
}
