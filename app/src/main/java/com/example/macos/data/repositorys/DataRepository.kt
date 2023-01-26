package com.example.macos.data.repositorys

import com.example.macos.domain.models.Card

interface DataRepository {
    suspend fun getCards(): List<Card>
    fun getExecutedTransactions()
    fun getPendingTransactions()
}