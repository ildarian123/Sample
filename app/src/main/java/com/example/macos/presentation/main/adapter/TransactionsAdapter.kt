package com.example.macos.presentation.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.macos.R
import com.example.macos.databinding.TransactionListItemBinding
import com.example.macos.domain.models.Transaction

class TransactionsAdapter(var transactionList: List<Transaction>,
) : RecyclerView.Adapter<TransactionsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: TransactionListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TransactionListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.v("transaq", "onCreateViewHolder ")
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(transactionList[position]){
                Log.v("transaq", "onBindViewHolder ")
                if (this.category.equals("transport")) {
                    binding.categoryImageView.setImageResource(R.drawable.ic_transport)
                }else if (this.category.equals("shopping")) {
                    binding.categoryImageView.setImageResource(R.drawable.ic_shopping)
                }else if (this.category.equals("service")) {
                    binding.categoryImageView.setImageResource(R.drawable.ic_services)
                }else if (this.category.equals("energy")) {
                    binding.categoryImageView.setImageResource(R.drawable.ic_home)
                }
                binding.merchantTextView.text = this.merchand
                binding.amountTextView.text = "${this.amount.toString()} ${this.currency}"
                binding.statusTextView.text = this.status
                binding.rvMainContainer.setOnClickListener {

                }
            }
        }
    }

    override fun getItemCount(): Int {
        Log.v("transaq", "transactionList.size "+ transactionList.size)
        return transactionList.size
    }
}