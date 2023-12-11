package com.example.tiptime.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tiptime.CalculatorViewModel
import com.example.tiptime.R
import com.example.tiptime.ui.theme.TipTimeTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel(),
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start),
        )

        TextField(
            value = viewModel.billAmount,
            onValueChange = { viewModel.changeBillAmount(it) },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
            label = { Text(stringResource(R.string.bill_amount)) },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.money),
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next,
            ),
            singleLine = true,
        )

        TextField(
            value = viewModel.tipPercent,
            onValueChange = { viewModel.changeTipPercentage(it) },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
            label = { Text(stringResource(R.string.tip_percentage)) },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.percent),
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
        )

        Row(
            modifier = Modifier.padding(bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(stringResource(R.string.round_up_tip))

            Switch(
                checked = viewModel.roundUp,
                onCheckedChange = { viewModel.onRoundUpChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
            )
        }

        Text(
            text = stringResource(R.string.tip_amount, viewModel.tipAmount),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displaySmall,
        )

        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    TipTimeTheme {
        MainScreen()
    }
}