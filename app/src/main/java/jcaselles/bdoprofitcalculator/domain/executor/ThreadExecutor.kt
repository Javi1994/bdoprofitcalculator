package com.payproapp.domain.executor

import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.Future

interface ThreadExecutor : Executor {
    fun submit(task: Runnable): Future<*>
    fun <T> submit(task: Callable<T>): Future<T>
}