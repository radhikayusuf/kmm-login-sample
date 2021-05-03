package com.radhikayusuf.lib.auth.utils

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/23/21
 */
expect object AuthDispatcher {
    internal val Main: CoroutineDispatcher

    internal val Background: CoroutineDispatcher
}