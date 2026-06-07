package com.wheelhouse.di

import com.wheelhouse.data.store.TokenStorage
import com.wheelhouse.data.store.UnauthorizedNotifier
import com.wheelhouse.data.store.createSettings
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun platformModule(platformContext: Any?) = module {
    single { createSettings(platformContext) }
    singleOf(::TokenStorage)
    singleOf(::UnauthorizedNotifier)
}
