package com.example.android.courses.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.courses.data.Datasource
import com.example.android.courses.model.CourseTopic
import com.example.android.courses.ui.theme.CourseProjectsTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    topics: List<CourseTopic> = Datasource.topics,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        modifier = modifier,
        contentPadding = PaddingValues(0.dp),
    ) {
        items(topics) { topic ->
            Topic(
                topic = topic,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CourseProjectsTheme {
        MainScreen()
    }
}