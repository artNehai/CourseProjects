package com.example.android.artspace.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android.artspace.ArtSpaceViewModel
import com.example.android.artspace.ui.theme.ArtSpaceTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ArtSpaceApp(
    modifier: Modifier = Modifier,
    viewModel: ArtSpaceViewModel = viewModel(),
) {
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 16.dp,
                    ),
                horizontalArrangement = Arrangement.Start,
            ) {
                NavigationButton(onClick = { viewModel.previousPainting() }) {
                    Text("Previous")
                }

                NavigationButton(
                    onClick = { viewModel.nextPainting() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End),
                ) {
                    Text("Next")
                }
            }
        }
    ) { innerPadding ->
        MainScreen(
            modifier = modifier
                .consumeWindowInsets(innerPadding)
                .padding(innerPadding),
            viewModel = viewModel,
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