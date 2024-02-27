package com.example.android.marsphotos

import com.example.android.marsphotos.data.NetworkMarsPhotosRepository
import com.example.android.marsphotos.fake.FakeDataSource
import com.example.android.marsphotos.fake.FakeMarsApiService
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkMarsPhotosRepositoryTests {

    @Test
    fun `getMarsPhotos() returns photo list`() = runTest {
        val repository = NetworkMarsPhotosRepository(marsApiService = FakeMarsApiService())
        assertEquals(repository.getMarsPhotos(), FakeDataSource.photosList)
    }
}