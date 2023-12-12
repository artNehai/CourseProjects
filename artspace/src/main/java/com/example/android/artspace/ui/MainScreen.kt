package com.example.android.artspace.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.artspace.R
import com.example.android.artspace.ui.theme.ArtSpaceTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .wrapContentHeight(Alignment.CenterVertically),
            shadowElevation = 16.dp,
        ) {
            Image(
                painter = painterResource(R.drawable.the_love_letter_fragonard),
                contentDescription = null,
                modifier = Modifier.padding(36.dp),
            )
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondaryContainer,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(
                    text = stringResource(R.string.love_letter),
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.bodyLarge,
                )

                Row {
                    Text(
                        text = stringResource(R.string.fragonard),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodySmall,
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = stringResource(R.string.love_letter_date),
                        fontWeight = FontWeight.Light,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            NavigationButton(onClick = {}) {
                Text("Previous")
            }

            NavigationButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
            ) {
                Text("Next")
            }
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