package com.example.android.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.KeyboardArrowDown
import androidx.compose.material.icons.sharp.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.woof.data.Dog
import com.example.android.woof.data.dogs
import com.example.android.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    WoofApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_woof_logo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(dimensionResource(R.dimen.image_size))
                                .padding(dimensionResource(R.dimen.padding_small)),
                        )
                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.displayLarge,
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
        ) {
            items(dogs) {
                DogItem(dog = it)
            }
        }
    }
}

@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier,
) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (isExpanded) {
            MaterialTheme.colorScheme.tertiaryContainer
        } else {
            MaterialTheme.colorScheme.primaryContainer
        },
        label = "Card's background color animation",
    )

    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .animateContentSize(
                animationSpec = spring(
                    stiffness = Spring.StiffnessMedium,
                ),
            ),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small)),
        ) {
            DogIcon(dog.imageResourceId)

            DogInformation(dog.name, dog.age)

            IconButton(
                onClick = { isExpanded = !isExpanded },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
            ) {
                Icon(
                    imageVector = if (isExpanded) {
                        Icons.Sharp.KeyboardArrowUp
                    } else {
                        Icons.Sharp.KeyboardArrowDown
                    },
                    contentDescription = stringResource(R.string.expand_button_content_description),
                    tint = MaterialTheme.colorScheme.secondary,
                )
            }
        }

        if (isExpanded) {
            DogHobby(
                hobby = dog.hobby,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium))
                    .padding(
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                    )
            )
        }
    }
}

@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(dogIcon),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)),
            style = MaterialTheme.typography.displayMedium,
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun DogHobby(
    @StringRes hobby: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall,
        )
        Text(
            text = stringResource(hobby),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun WoofPreview() {
    WoofTheme(darkTheme = false) {
        WoofApp()
    }
}
