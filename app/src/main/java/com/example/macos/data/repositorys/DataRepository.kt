package com.example.macos.data.repositorys

import com.example.macos.domain.models.Card
import com.example.macos.domain.models.Transaction

interface DataRepository {
    suspend fun getCards(): List<Card>
    suspend fun getExecutedTransactions(): List<Transaction>
    suspend fun getPendingTransactions(): List<Transaction>
}