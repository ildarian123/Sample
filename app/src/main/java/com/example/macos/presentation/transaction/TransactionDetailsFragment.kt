package com.example.macos.presentation.transaction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.macos.databinding.FragmentTransactionDetailsBinding
import com.example.macos.domain.models.Transaction
import com.example.macos.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionDetailsFragment : Fragment() {

    private lateinit var binding: FragmentTransactionDetailsBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTransactionDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transaction: Transaction = requireArguments().getParcelable("transaction")!!
        Log.d("tran", transaction.toString())

        binding.merchandTw.text = "Merchant: ${transaction.merchand}"
        binding.amountTw.text = "Amount: ${transaction.amount.toString()} ${transaction.currency}"
        binding.statusTw.text = "Status: ${transaction.status}"
    }
}