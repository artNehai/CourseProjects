package com.example.android.artspace.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.artspace.ui.theme.ArtSpaceTheme

@Composable
fun NavigationButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.width(136.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        content = content,
    )
}

@Preview
@Composable
fun NavigationButtonPreview() {
    ArtSpaceTheme {
        NavigationButton(onClick = {}) {
            Text("Button")
        }
    }
}