package com.example.macos.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.macos.domain.models.Card
import com.example.macos.domain.models.Transaction
import com.example.macos.domain.usecase.GetCardsUseCase
import com.example.macos.domain.usecase.GetTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCardsUseCase: GetCardsUseCase,
    private val getTransactionsUseCase: GetTransactionsUseCase
) :
    ViewModel() {

    protected val scope = CoroutineScope(Dispatchers.IO)

    var cards: MutableLiveData<List<Card>> = MutableLiveData()
    var transactions: MutableLiveData<List<Transaction>> = MutableLiveData()

    fun getCards() {
        scope.launch {
            cards.postValue(getCardsUseCase.execute())
        }
    }

    fun getTransactions() {
        scope.launch {
            transactions.postValue(getTransactionsUseCase.execute())
        }
    }

}