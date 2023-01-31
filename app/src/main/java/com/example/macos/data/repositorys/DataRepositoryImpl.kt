package com.example.macos.data.repositorys

import com.example.macos.data.network.NetworkApi
import com.example.macos.domain.models.Card
import com.example.macos.domain.models.Transaction
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val networkApi: NetworkApi) : DataRepository {
    override suspend fun getCards(): List<Card> {

        val result = networkApi.getCards()
        return result.body() ?: mutableListOf()
    }

    override suspend fun getExecutedTransactions(): List<Transaction> {
        val result = networkApi.getExecutedTransactions()
        return result.body() ?: mutableListOf()
    }

    override suspend fun getPendingTransactions(): List<Transaction> {
        val result = networkApi.getPendingTransactions()
        return result.body() ?: mutableListOf()
    }

}