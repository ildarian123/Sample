package com.example.macos.presentation.main.adapter

import com.example.macos.domain.models.Transaction

interface ClickListener {
    fun onClick(transaction: Transaction)
}