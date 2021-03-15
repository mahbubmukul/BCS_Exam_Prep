@file:Suppress("DEPRECATION")

package com.exam_prep.bcs.util
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.pm.ShortcutManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.provider.Settings
import android.text.Html
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

fun Context.showShortToast(resId: Int) = Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()

fun Context.showShortToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Fragment.showShortToast(resId: Int) = activity?.showShortToast(resId)

fun Fragment.showShortToast(message: String) = activity?.showShortToast(message)

fun Context.showLongToast(resId: Int) = Toast.makeText(this, resId, Toast.LENGTH_LONG).show()

fun Context.showLongToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun Fragment.showLongToast(resId: Int) = activity?.showLongToast(resId)

fun Fragment.showLongToast(message: String) = activity?.showLongToast(message)

fun String.isValidEmailAddress() = this.matches("(.+)@(.+\\.)?(.+)".toRegex())
fun String.isValidMobileNumber() = this.replace("[\\d()\\s.+\\-]".toRegex(), "").isEmpty()

fun Fragment.hideKeyboard() {
    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view?.windowToken, 0)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun Context.isConnectionAvailable(): Boolean {
    var result = false
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    } else {
        connectivityManager.run {
            connectivityManager.activeNetworkInfo?.run {
                result = when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }

            }
        }
    }

    return result
}

fun Fragment.isConnectionAvailable() = activity?.isConnectionAvailable()!!

@SuppressLint("HardwareIds")
fun Context.getDeviceId() =
    (Build.MODEL + "-" + Settings.Secure.getString(
        contentResolver,
        Settings.Secure.ANDROID_ID
    )).replace(Regex("\\s+"), "-")

fun Long.format(minLength: Int): String {
    return if (this.toString().length < minLength) {
        val leadingZero = minLength - this.toString().length
        var temp = ""
        for (i in 0 until leadingZero) {
            temp += "0"
        }
        temp += this
        temp
    } else {
        this.toString()
    }
}

fun Context.isPlayServicesAvailable(): Boolean {
    val resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this)
    return (resultCode == ConnectionResult.SUCCESS).apply {
        if (!this) {
            if (this@isPlayServicesAvailable is Activity)
                GoogleApiAvailability.getInstance().getErrorDialog(this@isPlayServicesAvailable, resultCode, 2)!!.show()
        }
    }
}

@TargetApi(Build.VERSION_CODES.N_MR1)
fun Context.clearAppShortCut() = getSystemService(ShortcutManager::class.java)?.removeAllDynamicShortcuts()

/**
 * Converts this triple into a list.
 */
fun <T> Quadruple<T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth)

fun fromHtmlSupport(source: String?) = (if (source.isNullOrBlank()) { ""
} else {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(source, Html.FROM_HTML_MODE_COMPACT)
    } else {
        HtmlCompat.fromHtml(source, HtmlCompat.FROM_HTML_MODE_LEGACY);
    }
})!!