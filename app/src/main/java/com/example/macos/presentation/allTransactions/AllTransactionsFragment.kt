package com.example.macos.presentation.allTransactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.macos.R
import com.example.macos.databinding.FragmentAllTransactionsBinding
import com.example.macos.domain.models.Transaction
import com.example.macos.presentation.main.MainViewModel
import com.example.macos.presentation.main.adapter.ClickListener
import com.example.macos.presentation.main.adapter.PositionListener
import com.example.macos.presentation.main.adapter.TransactionsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTransactionsFragment : Fragment(), ClickListener, PositionListener {
    private lateinit var binding: FragmentAllTransactionsBinding
    val vm:MainViewModel by viewModels()
    lateinit var mAdapter: TransactionsAdapter
    lateinit var transactionsData: List<Transaction>
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navController = findNavController()
        binding = FragmentAllTransactionsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getTransactions()
        vm.transactions.observe(viewLifecycleOwner) {
            transactionsData = vm.transactions.value?: listOf()
            val manager:RecyclerView.LayoutManager =
                LinearLayoutManager(activity)
            mAdapter = TransactionsAdapter(transactionsData.subList(0,19), clickListener = this, this)

            binding.rvAllTransactions.layoutManager = manager
            binding.rvAllTransactions.adapter = mAdapter
        }
    }

    override fun onClick(transaction: Transaction) {
        val bundle = bundleOf(Pair("transaction", transaction))
        navController.navigate(
            R.id.all_transaction_details_fragment_to_fragment_transaction_details,
            bundle
        )
    }

    override fun onLastItemShown(position: Int) {
        var indexTo = 0
        if (transactionsData.size < position + 20) indexTo = transactionsData.size
        else indexTo = position + 20
        mAdapter = TransactionsAdapter(transactionsData.subList(0,indexTo), clickListener = this, this)
        binding.rvAllTransactions.adapter = mAdapter
    }

}