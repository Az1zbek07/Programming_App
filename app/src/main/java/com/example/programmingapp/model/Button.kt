package com.example.programmingapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Button(
    val names: String
): Parcelable
