package com.wheelhouse.data.store

class UnauthorizedNotifier {

    private val listeners = mutableListOf<() -> Unit>()

    fun addListener(listener: () -> Unit) {
        listeners.add(listener)
    }

    fun notifyUnauthorized() {
        listeners.toList().forEach { it.invoke() }
    }
}
