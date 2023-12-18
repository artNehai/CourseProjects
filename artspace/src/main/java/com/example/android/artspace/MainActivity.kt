package com.example.android.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.android.artspace.ui.ArtSpaceApp
import com.example.android.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ArtSpaceViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp(
                    viewModel = viewModel,
                )
            }
        }
    }
}