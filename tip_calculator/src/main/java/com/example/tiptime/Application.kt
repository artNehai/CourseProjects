package com.example.tiptime

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tiptime.ui.MainScreen
import com.example.tiptime.ui.theme.TipTimeTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Application(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel(),
) {
    Scaffold { innerPadding ->
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
fun ApplicationPreview() {
    TipTimeTheme {
        Application()
    }
}