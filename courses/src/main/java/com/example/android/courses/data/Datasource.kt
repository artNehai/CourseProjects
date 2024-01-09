package com.example.android.courses.data

import com.example.android.courses.R
import com.example.android.courses.model.CourseTopic

object Datasource {
    val topics = listOf(
        CourseTopic(R.drawable.architecture, R.string.architecture, R.integer.architecture_courses),
        CourseTopic(R.drawable.crafts, R.string.crafts, R.integer.crafts_courses),
        CourseTopic(R.drawable.business, R.string.business, R.integer.business_courses),
        CourseTopic(R.drawable.culinary, R.string.culinary, R.integer.culinary_courses),
        CourseTopic(R.drawable.design, R.string.design, R.integer.design_courses),
        CourseTopic(R.drawable.fashion, R.string.fashion, R.integer.fashion_courses),
        CourseTopic(R.drawable.film, R.string.film, R.integer.film_courses),
        CourseTopic(R.drawable.gaming, R.string.gaming, R.integer.gaming_courses),
        CourseTopic(R.drawable.drawing, R.string.drawing, R.integer.drawing_courses),
        CourseTopic(R.drawable.lifestyle, R.string.lifestyle, R.integer.lifestyle_courses),
        CourseTopic(R.drawable.music, R.string.music, R.integer.music_courses),
        CourseTopic(R.drawable.painting, R.string.painting, R.integer.painting_courses),
        CourseTopic(R.drawable.photography, R.string.photography, R.integer.photography_courses),
        CourseTopic(R.drawable.tech, R.string.tech, R.integer.tech_courses),
    )
}