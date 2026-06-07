package com.wheelhouse.di

import com.wheelhouse.data.model.auth.UserSession
import com.wheelhouse.domain.repository.AuthRepository
import com.wheelhouse.presentation.viewmodel.AuthSharedViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

private var koinApp: KoinApplication? = null

object WheelhouseKoin {
    fun doInitKoin(platformContext: Any? = null) {
        koinApp = startKoin {
            modules(sharedKoinModules(platformContext))
        }
    }

    fun getAuthViewModel(): AuthSharedViewModel = koinApp!!.koin.get<AuthSharedViewModel>()

    fun getStoredSession(): UserSession? = koinApp!!.koin.get<AuthRepository>().getSession()
}

fun initKoin(platformContext: Any? = null) {
    WheelhouseKoin.doInitKoin(platformContext)
}

fun getAuthViewModel(): AuthSharedViewModel = WheelhouseKoin.getAuthViewModel()

fun getStoredSession(): UserSession? = WheelhouseKoin.getStoredSession()
