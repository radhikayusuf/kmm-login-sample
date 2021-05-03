
package com.radhikayusuf.lib.auth.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/23/21
 */
actual object AuthDispatcher {
    internal actual val Main: CoroutineDispatcher = Dispatchers.Main

    internal actual val Background: CoroutineDispatcher = Dispatchers.Default
}