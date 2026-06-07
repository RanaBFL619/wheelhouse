package com.wheelhouse.di

import org.koin.core.module.Module

val sharedKoinModules: (platformContext: Any?) -> List<Module> = { platformContext ->
    listOf(
        platformModule(platformContext),
        repositoryModule,
        useCaseModule,
        viewModelModule
    )
}
