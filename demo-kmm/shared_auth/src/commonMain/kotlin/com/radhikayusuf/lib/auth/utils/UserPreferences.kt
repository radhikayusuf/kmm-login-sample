package com.radhikayusuf.lib.auth.utils

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/28/21
 */
expect class UserPreferences {

    fun putString(key: String, value: String)

    fun putInt(key: String, value: Int)

    fun getString(key: String): String?

    fun getInt(key: String): Int?
}