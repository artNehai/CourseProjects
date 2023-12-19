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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android.artspace.ArtSpaceViewModel
import com.example.android.artspace.ui.theme.ArtSpaceTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: ArtSpaceViewModel = viewModel(),
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
                painter = painterResource(viewModel.currentPainting.imageId),
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
                    text = stringResource(viewModel.currentPainting.titleId),
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.bodyLarge,
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(stringResource(viewModel.currentPainting.authorId))
                            append(" ")
                        }
                        withStyle(SpanStyle(fontWeight = FontWeight.Light)) {
                            append(stringResource(viewModel.currentPainting.creationDateId))
                            append(" ")
                        }
                        toAnnotatedString()
                    },
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 16.dp),
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
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    ArtSpaceTheme {
        MainScreen()
    }
}