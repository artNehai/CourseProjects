package com.example.android.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class CourseTopic(
    @DrawableRes val image: Int,
    @StringRes val description: Int,
    @IntegerRes val coursesQnt: Int,
)