package com.example.android.courses.data

import com.example.android.courses.R
import com.example.android.courses.model.Course

object Datasource {
    val courses = listOf(
        Course(R.drawable.architecture, R.string.architecture, R.integer.architecture_courses),
        Course(R.drawable.crafts, R.string.crafts, R.integer.crafts_courses),
        Course(R.drawable.business, R.string.business, R.integer.business_courses),
        Course(R.drawable.culinary, R.string.culinary, R.integer.culinary_courses),
        Course(R.drawable.design, R.string.design, R.integer.design_courses),
        Course(R.drawable.fashion, R.string.fashion, R.integer.fashion_courses),
        Course(R.drawable.film, R.string.film, R.integer.film_courses),
        Course(R.drawable.gaming, R.string.gaming, R.integer.gaming_courses),
        Course(R.drawable.drawing, R.string.drawing, R.integer.drawing_courses),
        Course(R.drawable.lifestyle, R.string.lifestyle, R.integer.lifestyle_courses),
        Course(R.drawable.music, R.string.music, R.integer.music_courses),
        Course(R.drawable.painting, R.string.painting, R.integer.painting_courses),
        Course(R.drawable.photography, R.string.photography, R.integer.photography_courses),
        Course(R.drawable.tech, R.string.tech, R.integer.tech_courses),
    )
}