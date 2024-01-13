package com.example.android.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.superheroes.data.HeroesRepository
import com.example.android.superheroes.model.Hero
import com.example.android.superheroes.ui.HeroesList
import com.example.android.superheroes.ui.SuperheroesTopBar
import com.example.android.superheroes.ui.theme.SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperheroesApp(heroes = HeroesRepository.heroes)
                }
            }
        }
    }
}

@Composable
fun SuperheroesApp(
    heroes: List<Hero>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SuperheroesTopBar() },
    ) { paddingValues ->
        HeroesList(
            heroes = heroes,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
fun SuperheroesAppPreview() {
    SuperheroesAppTheme {
        SuperheroesApp(heroes = HeroesRepository.heroes)
    }
}