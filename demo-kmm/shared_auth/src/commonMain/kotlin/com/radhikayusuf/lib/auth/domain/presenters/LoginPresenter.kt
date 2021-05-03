package com.radhikayusuf.lib.auth.domain.presenters

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/28/21
 */
interface LoginPresenter {

    fun showMessage(message: String)

    fun onLoginSuccess()
}