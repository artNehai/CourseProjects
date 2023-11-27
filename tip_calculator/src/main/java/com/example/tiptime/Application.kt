package com.example.tiptime

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tiptime.ui.MainScreen
import com.example.tiptime.ui.theme.TipTimeTheme

@Composable
fun Application() {
    Scaffold { paddingValues ->
        MainScreen(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ApplicationPreview() {
    TipTimeTheme {
        Application()
    }
}