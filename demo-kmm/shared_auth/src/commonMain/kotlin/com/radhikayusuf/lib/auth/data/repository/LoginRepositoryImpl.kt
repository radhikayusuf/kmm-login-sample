package com.radhikayusuf.lib.auth.data.repository

import com.radhikayusuf.lib.auth.data.model.Result
import com.radhikayusuf.lib.auth.data.services.AuthServices
import com.radhikayusuf.lib.auth.domain.entities.UserEntity
import com.radhikayusuf.lib.auth.domain.usecases.LoginRepository
import com.radhikayusuf.lib.auth.utils.UserPreferences

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/17/21
 */

class LoginRepositoryImpl(
    private val service: AuthServices = AuthServices(),
    private val preferences: UserPreferences
) : LoginRepository {

    override suspend fun doLoginByUserKey(userKey: String): Result<UserEntity> {
        val result = service.login(userKey)
        return if (result.status == 200 && result.data != null) {
            val userEntity = UserEntity(
                result.data.id.orEmpty(),
                "${result.data.firstName} ${result.data.lastName}",
                result.data.email.orEmpty(),
                result.data.picture.orEmpty()
            )
            Result(true, userEntity, result.message.orEmpty())
        } else {
            Result(false, null, result.message.orEmpty())
        }
    }

    override suspend fun saveUserInfo(key: String, value: String) {
        preferences.putString(key, value)
    }
}