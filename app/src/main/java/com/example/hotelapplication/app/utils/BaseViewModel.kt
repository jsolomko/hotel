package com.example.hotelapplication.app.utils

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.IOException

open class BaseViewModel(@ApplicationContext val context: Context) : ViewModel() {

    private var _iOExceptionEvent = MutableLiveData<Boolean>()
    var iOExceptionEvent = _iOExceptionEvent.share()

    private lateinit var connectivityManager: ConnectivityManager

    private var _onAvailableEvent = MutableLiveData<Boolean>()
    val onAvailableEvent = _onAvailableEvent.share()

    fun CoroutineScope.safeLaunch(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: IOException) {
                processIOException(e)
                observeConnection()
            }
        }

    }

    private fun processIOException(e: IOException) {
        _iOExceptionEvent.value = true
    }

    fun observeConnection() {
        connectivityManager =
            context.getSystemService(ConnectivityManager::class.java) as ConnectivityManager

        connectivityManager.requestNetwork(
            NetworkReq.request,
            ConnectionCallback(context) {
                _onAvailableEvent.value = true
            })
    }
}