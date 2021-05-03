package com.radhikayusuf.lib.auth.utils

import platform.Foundation.NSUserDefaults

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/28/21
 */
actual class UserPreferences {

    private val preferences: NSUserDefaults by lazy { NSUserDefaults.standardUserDefaults }

    actual fun putString(key: String, value: String) {
        preferences.setObject(value, key)
    }

    actual fun putInt(key: String, value: Int) {
        preferences.setInteger(value.toLong(), key)
    }

    actual fun getString(key: String): String? {
        return preferences.objectForKey(key)?.toString().orEmpty()
    }

    actual fun getInt(key: String): Int? {
        return preferences.integerForKey(key).toInt()
    }
}