package com.wearebrain.ake.context

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Check if device is connected to network
 *
 * @return true - if connected, otherwise - false
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.CONNECTIVITY_SERVICE
 * @see ConnectivityManager
 * @see ConnectivityManager.getActiveNetworkInfo
 * @see NetworkInfo
 * @see NetworkInfo.isConnected
 */
fun Context.networkAvailable(): Boolean {
    val connectivityManager = connectivityService()
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnected
}

/**
 * Check if device is not connected to network
 *
 * @return true - if not connected, otherwise - false
 *
 * @see Context.getSystemService
 * @see Context.getSystemService
 * @see Context.CONNECTIVITY_SERVICE
 * @see ConnectivityManager
 * @see ConnectivityManager.getActiveNetworkInfo
 * @see NetworkInfo
 * @see NetworkInfo.isConnected
 */
fun Context.networkUnavailable(): Boolean = !networkAvailable()