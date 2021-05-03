package com.radhikayusuf.lib.auth.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/28/21
 */

fun CoroutineScope.runOnMain(block: suspend () -> Unit) {
    launch(AuthDispatcher.Main) { block.invoke() }
}