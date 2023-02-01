package com.example.macos.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.macos.databinding.TransactionListItemBinding
import com.example.macos.domain.models.Transaction

class TransactionsAdapter(var transactionList: List<Transaction>,
) : RecyclerView.Adapter<TransactionsAdapter.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie SingleItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: TransactionListItemBinding) : RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TransactionListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.v("transaq", "onCreateViewHolder ")
        return ViewHolder(binding)
    }

    // bind the items with each item
    // of the list languageList
    // which than will be
    // shown in recycler view
    // to keep it simple we are
    // not setting any image data to view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(transactionList[position]){
                Log.v("transaq", "onBindViewHolder ")
                binding.merchantTextView.text = this.merchand
                binding.amountTextView.text = this.amount.toString()
//                 binding.categoryImageView.text = this.
                binding.statusTextView.text = this.category
            }
        }
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        Log.v("transaq", "transactionList.size "+ transactionList.size)
        return transactionList.size
    }
}