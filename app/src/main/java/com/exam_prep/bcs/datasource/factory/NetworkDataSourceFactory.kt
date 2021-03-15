package com.exam_prep.bcs.datasource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.exam_prep.bcs.datasource.NetworkDataSource

abstract class NetworkDataSourceFactory<Key, Value> : DataSource.Factory<Key, Value>() {
    val sourceLiveData = MutableLiveData<NetworkDataSource<Key, Value>>()
}