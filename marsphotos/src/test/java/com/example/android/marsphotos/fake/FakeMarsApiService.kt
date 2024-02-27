package com.example.android.marsphotos.fake

import com.example.android.marsphotos.network.MarsApiService

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos() = FakeDataSource.photosList
}