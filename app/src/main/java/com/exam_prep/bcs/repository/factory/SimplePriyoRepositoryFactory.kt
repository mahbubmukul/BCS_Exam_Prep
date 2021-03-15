package com.exam_prep.bcs.repository.factory

import java.util.concurrent.Executors

class SimplePriyoRepositoryFactory : PriyoRepositoryFactory {

    companion object {
        private val LOCK = Any()
        private val DISK_IO = Executors.newSingleThreadExecutor()
        private val NETWORK_IO = Executors.newFixedThreadPool(5)

        private var instance: PriyoRepositoryFactory? = null

        fun create(): PriyoRepositoryFactory {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = SimplePriyoRepositoryFactory()
                }
            }
            return instance!!
        }
    }
    override fun getNetworkExecutor() = NETWORK_IO!!

    override fun getDiskIOExecutor() = DISK_IO!!

}