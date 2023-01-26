package com.example.macos.data.repositorys

import com.example.macos.data.network.NetworkApi
import com.example.macos.domain.models.Card
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val networkApi: NetworkApi): DataRepository {
    override suspend fun getCards(): List<Card> {

        val result = networkApi.getCards()
        return result.body()?: mutableListOf()
    }

    override fun getExecutedTransactions() {
        TODO("Not yet implemented")
    }

    override fun getPendingTransactions() {
        TODO("Not yet implemented")
    }

}