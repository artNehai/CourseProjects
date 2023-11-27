package com.example.tiptime

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tiptime.ui.MainScreen
import com.example.tiptime.ui.theme.TipTimeTheme

@Composable
fun Application(
    billAmount: String,
    tipAmount: String,
    onBillAmountChange: (String) -> Unit,
) {
    Scaffold { paddingValues ->
        MainScreen(
            billAmount = billAmount,
            tipAmount = tipAmount,
            onBillAmountChange = onBillAmountChange,
            modifier = Modifier.padding(paddingValues),
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