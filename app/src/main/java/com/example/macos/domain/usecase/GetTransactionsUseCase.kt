package com.example.macos.domain.usecase

import com.example.macos.data.repositorys.DataRepositoryImpl
import com.example.macos.domain.models.Transaction
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(private val dataRepository: DataRepositoryImpl) {
    suspend fun execute(): List<Transaction> {
        return dataRepository.getPendingTransactions()
    }
}