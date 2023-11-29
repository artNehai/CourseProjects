package com.example.tiptime

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tiptime.ui.MainScreen
import com.example.tiptime.ui.theme.TipTimeTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Application(
    billAmount: String,
    tipAmount: String,
    onBillAmountChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold { innerPadding ->
        MainScreen(
            billAmount = billAmount,
            tipAmount = tipAmount,
            onBillAmountChange = onBillAmountChange,
            modifier = modifier
                .consumeWindowInsets(innerPadding)
                .padding(innerPadding),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ApplicationPreview() {
    TipTimeTheme {
        Application(
            billAmount = "",
            tipAmount = "",
            onBillAmountChange = {},
        )
    }
}