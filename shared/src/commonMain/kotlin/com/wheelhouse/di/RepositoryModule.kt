package com.wheelhouse.di

import com.wheelhouse.data.repository.AuthRepositoryImpl
import com.wheelhouse.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}
