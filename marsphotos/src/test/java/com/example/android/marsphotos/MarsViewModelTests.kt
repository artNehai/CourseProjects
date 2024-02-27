package com.example.android.marsphotos

import com.example.android.marsphotos.fake.FakeDataSource
import com.example.android.marsphotos.fake.FakeNetworkMarsPhotosRepository
import com.example.android.marsphotos.rules.TestDispatcherRule
import com.example.android.marsphotos.ui.MarsViewModel
import com.example.android.marsphotos.ui.components.MarsUiState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class MarsViewModelTests {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun `getMarsPhoto() call returns MarsUiState_Success`() = runTest {
        val marsViewModel = MarsViewModel(marsPhotosRepository = FakeNetworkMarsPhotosRepository())
        assertEquals(
            marsViewModel.marsUiState,
            MarsUiState.Success("Success: ${FakeDataSource.photosList.size} Mars photos retrieved")
        )
    }
}