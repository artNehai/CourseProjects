package com.example.android.superheroes.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.superheroes.data.HeroesRepository
import com.example.android.superheroes.model.Hero
import com.example.android.superheroes.ui.theme.SuperheroesAppTheme

@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
    ) {
        items(heroes) {
            HeroCard(hero = it)

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeroesListPreview() {
    SuperheroesAppTheme {
        HeroesList(heroes = HeroesRepository.heroes)
    }
}