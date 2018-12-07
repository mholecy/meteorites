package sk.mholecy.meteorites.common.extensions

import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

fun Context.isOnline(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetworkInfo
    return activeNetwork?.isConnected == true
}

fun Snackbar.setBackgroundColor(@ColorRes colorId: Int) {
    this.view.setBackgroundColor(ContextCompat.getColor(this.context, colorId))
}

fun Snackbar.setActionTextColorId(@ColorRes colorId: Int) {
    this.setActionTextColor(ContextCompat.getColor(this.context, colorId))
}
