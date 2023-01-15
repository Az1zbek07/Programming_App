package com.example.programmingapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ButtonLesson(
    val numberLesson: Int
): Parcelable
