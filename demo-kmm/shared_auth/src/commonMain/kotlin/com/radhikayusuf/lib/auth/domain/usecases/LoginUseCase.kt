package com.radhikayusuf.lib.auth.domain.usecases

import com.radhikayusuf.lib.auth.domain.entities.UserEntity
import com.radhikayusuf.lib.auth.domain.presenters.LoginPresenter
import com.radhikayusuf.lib.auth.utils.AuthDispatcher
import com.radhikayusuf.lib.auth.utils.runOnMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/28/21
 */
class LoginUseCase(
    private val loginRepository: LoginRepository,
    private val loginPresenter: LoginPresenter
): CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = AuthDispatcher.Background

    fun doLoginByKey(key: String) {
        launch {
            if (key.isBlank()) {
                runOnMain { loginPresenter.showMessage("User Key tidak boleh kosong") }
                return@launch
            }

            if (key.length < MINIMUM_KEY_LENGTH) {
                runOnMain { loginPresenter.showMessage("Minimal panjang User key harus 12 karakter") }
                return@launch
            }

            val result = withContext(AuthDispatcher.Background) { loginRepository.doLoginByUserKey(key) }
            if (result.isSuccess) {
                saveLoginInfo(userEntity = result.data ?: return@launch)
                runOnMain(loginPresenter::onLoginSuccess)
            } else {
                runOnMain { loginPresenter.showMessage(result.message) }
            }
        }
    }

    private suspend fun saveLoginInfo(userEntity: UserEntity) {
        userEntity.toMap().forEach {
            loginRepository.saveUserInfo(it.key, it.value)
        }
    }

    companion object {
        const val MINIMUM_KEY_LENGTH = 12
    }
}