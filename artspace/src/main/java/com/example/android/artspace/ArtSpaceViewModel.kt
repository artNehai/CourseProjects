package com.example.android.artspace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ArtSpaceViewModel : ViewModel() {

    private val paintings = listOf(
        PaintingBundle(
            imageId = R.drawable.the_love_letter_fragonard,
            titleId = R.string.love_letter,
            authorId = R.string.fragonard,
            creationDateId = R.string.love_letter_date,
        ),
        PaintingBundle(
            imageId = R.drawable.allegory_of_the_planets_and_continents_tiepolo,
            titleId = R.string.planets_and_continents,
            authorId = R.string.tiepolo,
            creationDateId = R.string.planets_and_continents_date,
        ),
        PaintingBundle(
            imageId = R.drawable.head_of_the_madonna_franciabigio,
            titleId = R.string.madonna,
            authorId = R.string.franciabigio,
            creationDateId = R.string.madonna_date,
        ),
    )

    var currentPainting by mutableStateOf(paintings.first())
        private set

    fun nextPainting() {
        if (currentPainting == paintings.last()) return
        val currentIndex = paintings.indexOf(currentPainting)
        currentPainting = paintings[currentIndex + 1]
    }

    fun previousPainting() {
        if (currentPainting == paintings.first()) return
        val currentIndex = paintings.indexOf(currentPainting)
        currentPainting = paintings[currentIndex - 1]
    }

    data class PaintingBundle(
        @DrawableRes val imageId: Int,
        @StringRes val titleId: Int,
        @StringRes val authorId: Int,
        @StringRes val creationDateId: Int,
    )
}

