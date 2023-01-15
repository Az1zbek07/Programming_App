package com.example.programmingapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lesson(
    val name: String,
    val numberOfLessons: Int,
    val image: Int
): Parcelable
