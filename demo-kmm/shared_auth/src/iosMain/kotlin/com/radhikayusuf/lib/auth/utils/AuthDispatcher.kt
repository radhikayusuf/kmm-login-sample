
package com.radhikayusuf.lib.auth.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

/**
 * @Author by Radhika Yusuf
 * Bandung, on 4/23/21
 */
actual object AuthDispatcher {
    internal actual val Main: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())

    internal actual val Background: CoroutineDispatcher = Main

    internal class NsQueueDispatcher(
        private val dispatchQueue: dispatch_queue_t
    ) : CoroutineDispatcher() {
        override fun dispatch(context: CoroutineContext, block: Runnable) {
            dispatch_async(dispatchQueue) {
                block.run()
            }
        }
    }
}