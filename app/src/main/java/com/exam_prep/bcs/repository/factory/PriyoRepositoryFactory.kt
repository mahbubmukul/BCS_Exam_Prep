package com.exam_prep.bcs.repository.factory

import java.util.concurrent.Executor

interface PriyoRepositoryFactory {

    fun getNetworkExecutor(): Executor

    fun getDiskIOExecutor(): Executor
}