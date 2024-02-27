package com.example.android.marsphotos.fake

import com.example.android.marsphotos.data.MarsPhotosRepository

class FakeNetworkMarsPhotosRepository : MarsPhotosRepository {
    override suspend fun getMarsPhotos() = FakeDataSource.photosList
}