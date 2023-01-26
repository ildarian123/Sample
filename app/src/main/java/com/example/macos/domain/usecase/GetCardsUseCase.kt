package com.example.macos.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.macos.data.repositorys.DataRepositoryImpl
import com.example.macos.domain.models.Card
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val dataRepository: DataRepositoryImpl) {

    val cards: LiveData<List<Card>> = MutableLiveData()

    suspend fun execute(): List<Card> {
        return dataRepository.getCards()
    }

}