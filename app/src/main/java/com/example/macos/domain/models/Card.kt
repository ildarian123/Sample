package com.example.macos.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    val id: Int? = null,
    val type: String? = null,
    val numbers: String? = null,
    val amount: String? = null,
    val currency: String? = null
): Parcelable