package com.radhikayusuf.lib.auth.data.model

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/23/21
 */
data class Result<T>(
    val isSuccess: Boolean,
    val data: T?,
    val message: String
)