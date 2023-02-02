package com.example.macos.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Transaction(
    val id: Int? = null,
    val merchand: String? = null,
    val category: String? = null,
    val amount: Int? = null,
    val currency: String? = null,
    val timestamp: Int? = null,
    var status: String? = null
): Parcelable