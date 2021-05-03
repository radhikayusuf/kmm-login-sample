package com.radhikayusuf.lib.auth.domain.usecases

import com.radhikayusuf.lib.auth.data.model.Result
import com.radhikayusuf.lib.auth.domain.entities.UserEntity

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/28/21
 */
interface LoginRepository {

    suspend fun doLoginByUserKey(userKey: String): Result<UserEntity>

    suspend fun saveUserInfo(key: String, value: String)
}