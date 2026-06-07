package com.wheelhouse.di

import com.wheelhouse.domain.usecase.auth.LoginUseCase
import com.wheelhouse.domain.usecase.auth.LogoutUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get()) }
    single { LogoutUseCase(get()) }
}
