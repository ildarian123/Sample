package com.example.macos.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.macos.R
import com.example.macos.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        getData()
    }

    private fun getData() {
        vm.getCards()
        vm.getTransactions()
    }

    private fun setObservers() {
        vm.cards.observe(viewLifecycleOwner) {
            Log.d("network", it.toString())
        }
        vm.transactions.observe(viewLifecycleOwner) {

            val manager:RecyclerView.LayoutManager =
                LinearLayoutManager(context)
            binding.rvTransactions.layoutManager = manager
            binding.rvTransactions.adapter = TransactionsAdapter(vm.transactions.value?: mutableListOf()) {
                Log.d("network", "clicked")
            }

        }
    }
}