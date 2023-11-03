package com.example.bycodersexchange.extensions

import android.os.Parcelable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

fun NavController.navigate(route: String, vararg args: Pair<String, Parcelable>) {
    navigate(route)

    requireNotNull(currentBackStackEntry?.arguments).apply {
        args.forEach { (key: String, arg: Parcelable) ->
            putParcelable(key, arg)
        }
    }
}

inline fun <reified T : Parcelable> NavBackStackEntry.requiredArg(key: String): T? {
    return arguments?.run {
        requireNotNull(getParcelable(key)) { "argument for $key is null" }
    }
}