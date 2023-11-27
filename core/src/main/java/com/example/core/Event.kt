package com.example.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Event<T>(var value: T) {
    private var _value: T? = value
    fun get(): T? = _value.also { _value = null }
}

typealias MutableLiveEvent<T> = MutableLiveData<Event<T>>
typealias LiveEvent<T> = LiveData<Event<T>>
typealias EventListener<T> = (T) -> Unit

fun <T> MutableLiveEvent<T>.publishEvent(value: T) {
    this.value = Event(value)
}

fun <T> MutableLiveEvent<T>.publishPostEvent(value: T) {
    this.postValue(Event(value))
}

fun <T> LiveEvent<T>.observeEvent(lifecycleOwner: LifecycleOwner, eventListener: EventListener<T>) {
    this.observe(lifecycleOwner) {
        it.get()?.let { value ->
            eventListener(value)
        }
    }
}