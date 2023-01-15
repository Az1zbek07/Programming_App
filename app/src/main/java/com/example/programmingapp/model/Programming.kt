package com.example.programmingapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Programming(
    val name: String,
    val namesOfLessons: MutableList<String>
): Parcelable
