package com.example.android.superheroes.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.superheroes.data.HeroesRepository
import com.example.android.superheroes.model.Hero
import com.example.android.superheroes.ui.theme.Shapes
import com.example.android.superheroes.ui.theme.SuperheroesAppTheme

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = Shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp),
        ) {
            Column {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,
                )

                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            Spacer(Modifier.width(16.dp))

            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = null,
                modifier = Modifier.clip(Shapes.small),
            )
        }
    }
}

@Preview
@Composable
fun HeroCardPreview() {
    SuperheroesAppTheme {
        HeroCard(HeroesRepository.heroes.first())
    }
}