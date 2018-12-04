package sk.mholecy.meteorites.common.extensions

import android.content.Context
import android.net.ConnectivityManager

fun Context.isOnline(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetworkInfo
    return activeNetwork?.isConnected == true
}
