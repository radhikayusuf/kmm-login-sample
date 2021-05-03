package com.radhikayusuf.lib.auth.utils

import android.content.Context

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/28/21
 */
actual class UserPreferences(
    private val context: Context
) {
    private val sharedPreferences get() = context.getSharedPreferences("auth-key", Context.MODE_PRIVATE)

    actual fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    actual fun putInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    actual fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    actual fun getInt(key: String): Int? {
        return sharedPreferences.getInt(key, 0)
    }
}