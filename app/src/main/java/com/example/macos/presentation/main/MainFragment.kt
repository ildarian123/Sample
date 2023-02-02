package com.example.macos.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.macos.R
import com.example.macos.databinding.FragmentMainBinding
import com.example.macos.domain.models.Transaction
import com.example.macos.presentation.main.adapter.CardsAdapter
import com.example.macos.presentation.main.adapter.ClickListener
import com.example.macos.presentation.main.adapter.PositionListener
import com.example.macos.presentation.main.adapter.TransactionsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment(), ClickListener, PositionListener {

    private lateinit var binding: FragmentMainBinding
    private val vm: MainViewModel by viewModels()
    lateinit var navController: NavController
    lateinit var transactionsData: List<Transaction>
    lateinit var mAdapter: TransactionsAdapter
    val limit = 20

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = findNavController()
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        getData()
        setListeners()
    }

    private fun setListeners() {
        binding.viewAllTextView.setOnClickListener {
            navController.navigate(
                R.id.action_main_fragment_to_all_transaction_details_fragment
            )
        }

        binding.lockImageView.setOnClickListener {
            Toast.makeText(requireContext(), "Lock card", Toast.LENGTH_SHORT).show()
        }
        binding.settingImageView.setOnClickListener {
            Toast.makeText(requireContext(), "Settings", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getData() {
        vm.getCards()
        vm.getTransactions()
    }

    private fun setObservers() {
        vm.cards.observe(viewLifecycleOwner) {
            LinearSnapHelper().attachToRecyclerView(binding.rvCards)
            val cardsAdapter = CardsAdapter(it)
            val manager:RecyclerView.LayoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, true)
            binding.rvCards.layoutManager = manager
            binding.rvCards.adapter = cardsAdapter
        }

        vm.transactions.observe(viewLifecycleOwner) {
            transactionsData = vm.transactions.value?: listOf()
            val manager:RecyclerView.LayoutManager =
                LinearLayoutManager(activity)
            mAdapter = TransactionsAdapter(transactionsData.subList(0,19), clickListener = this, this)

            Log.v("transaq", transactionsData.toString())
            binding.rvTransactions.layoutManager = manager
            binding.rvTransactions.adapter = mAdapter
        }
    }

    override fun onClick(transaction: Transaction) {
        val bundle = bundleOf(Pair("transaction", transaction))
        navController.navigate(
            R.id.action_main_fragment_to_transaction_details_fragment,
            bundle
        )
    }

    override fun onLastItemShown(position: Int) {
        var indexTo = 0
        indexTo = if (transactionsData.size < position + 20) transactionsData.size
        else position + 20
        mAdapter = TransactionsAdapter(transactionsData.subList(0,indexTo), clickListener = this, this)
        binding.rvTransactions.adapter = mAdapter
    }
}