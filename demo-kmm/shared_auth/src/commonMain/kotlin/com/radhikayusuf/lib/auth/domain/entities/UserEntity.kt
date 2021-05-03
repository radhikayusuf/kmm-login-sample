package com.radhikayusuf.lib.auth.domain.entities

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/28/21
 */
data class UserEntity(
    val userId: String,
    val name: String,
    val email: String,
    val pictureUrl: String
) {
    fun toMap(): HashMap<String, String> {
        return hashMapOf(
            KEY_USER_ID to userId,
            KEY_USER_NAME to name,
            KEY_USER_EMAIL to email,
            KEY_USER_PIC to pictureUrl
        )
    }

    companion object {
        const val KEY_USER_ID = "user_id"
        const val KEY_USER_NAME = "user_name"
        const val KEY_USER_EMAIL = "user_email"
        const val KEY_USER_PIC = "user_pic"
    }
}