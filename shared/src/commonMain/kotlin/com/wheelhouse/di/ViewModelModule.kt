package com.wheelhouse.di

import com.wheelhouse.presentation.viewmodel.AuthSharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val viewModelModule = module {
    single { CoroutineScope(SupervisorJob() + Dispatchers.Default) }
    single { AuthSharedViewModel(get(), get(), get(), get(), get()) }
}
