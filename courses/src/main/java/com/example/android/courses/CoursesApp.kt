package com.example.android.courses

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.courses.data.Datasource
import com.example.android.courses.ui.MainScreen
import com.example.android.courses.ui.theme.CourseProjectsTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoursesApp(
    modifier: Modifier = Modifier,
    datasource: Datasource = Datasource,
) {
    Scaffold(modifier) { paddingValues ->
        MainScreen(
            topics = datasource.topics,
            modifier = Modifier
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues),
        )
    }
}

@Preview
@Composable
fun CoursesAppPreview() {
    CourseProjectsTheme {
        CoursesApp()
    }
}