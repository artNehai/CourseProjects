package com.example.android.courses.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.courses.R
import com.example.android.courses.data.Datasource
import com.example.android.courses.model.CourseTopic
import com.example.android.courses.ui.theme.CourseProjectsTheme

@Composable
fun Topic(
    topic: CourseTopic,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(percent = 20),
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Row {
            Image(
                painter = painterResource(topic.image),
                contentDescription = null,
                modifier = Modifier.size(68.dp),
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
            ) {
                Text(
                    text = stringResource(topic.description),
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(Modifier.height(8.dp))

                Row {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                    )

                    Spacer(Modifier.width(8.dp))

                    Text(
                        text = integerResource(topic.coursesQnt).toString(),
                        modifier = Modifier.align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TopicPreview() {
    CourseProjectsTheme {
        Topic(topic = Datasource.topics.first())
    }
}