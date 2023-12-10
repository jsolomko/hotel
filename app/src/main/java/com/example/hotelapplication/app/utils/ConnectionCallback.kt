package com.example.hotelapplication.app.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.widget.Toast

class ConnectionCallback(
    val context: Context,
    val block: () -> Unit
) : ConnectivityManager.NetworkCallback() {

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        block.invoke()
    }

    override fun onCapabilitiesChanged(
        network: Network,
        networkCapabilities: NetworkCapabilities
    ) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        val unmetered =
            networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
    }

    override fun onLost(network: Network) {
        println("onStop")
        super.onLost(network)
        Toast.makeText(context, "NO NETWORK AVAILABLE", Toast.LENGTH_SHORT).show()
    }
}