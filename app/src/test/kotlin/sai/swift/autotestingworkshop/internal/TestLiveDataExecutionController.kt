package sai.swift.autotestingworkshop.internal

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor

object TestLiveDataExecutionController {

    fun enableTestMode() {
        ArchTaskExecutor.getInstance()
            .setDelegate(object : TaskExecutor() {
                override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

                override fun postToMainThread(runnable: Runnable) = runnable.run()

                override fun isMainThread(): Boolean = true
            })
    }

    fun disableTestMode() {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }
}
