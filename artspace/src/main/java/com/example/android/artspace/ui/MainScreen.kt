package com.example.android.artspace.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.artspace.R
import com.example.android.artspace.ui.theme.ArtSpaceTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            shadowElevation = 16.dp,
        ) {
            Image(
                painter = painterResource(R.drawable.the_lover_letter_fragonard),
                contentDescription = null,
                modifier = Modifier.padding(36.dp),
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    ArtSpaceTheme {
        MainScreen()
    }
}