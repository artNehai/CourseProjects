package com.example.android.artspace.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Min),
        ) {
            Surface(
                modifier = Modifier.width(PaintingWidth),
                shadowElevation = 16.dp,
            ) {
                Image(
                    painter = painterResource(viewModel.currentPainting.imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(28.dp),
                )
            }

            Spacer(Modifier.height(20.dp))

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
        }
    }
}

private val PaintingWidth = 426.dp

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    ArtSpaceTheme {
        MainScreen()
    }
}