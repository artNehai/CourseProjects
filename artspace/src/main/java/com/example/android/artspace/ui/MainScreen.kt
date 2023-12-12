package com.example.android.artspace.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.artspace.ui.theme.ArtSpaceTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    ArtSpaceTheme {
        MainScreen()
    }
}