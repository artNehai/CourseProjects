package com.example.android.artspace

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.artspace.ui.MainScreen
import com.example.android.artspace.ui.theme.ArtSpaceTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ArtSpaceApp(
    modifier: Modifier = Modifier,
) {
    Scaffold { innerPadding ->
        MainScreen(
            modifier = modifier
                .consumeWindowInsets(innerPadding)
                .padding(innerPadding),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CalculatorAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}