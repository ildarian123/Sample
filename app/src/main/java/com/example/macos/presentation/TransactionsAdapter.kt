package com.example.macos.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.macos.R
import com.example.macos.domain.models.Transaction
import com.squareup.picasso.Picasso

class TransactionsAdapter(val collection: MutableList<Transaction>, val clickListener: (Transaction) -> Unit) :
    RecyclerView.Adapter<TransactionsAdapter.ListOfTransactionsHolder>() {

    inner class ListOfTransactionsHolder(itemView: View, clickAtPosition: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val category_image_view =
            itemView.findViewById<ImageView>(R.id.category_image_view)
        private val merchant_text_view =
            itemView.findViewById<TextView>(R.id.merchant_text_view)
        private val amount_text_view =
            itemView.findViewById<TextView>(R.id.amount_text_view)
        private val status_text_view =
            itemView.findViewById<TextView>(R.id.status_text_view)

        init {
            itemView.setOnClickListener {
            }
        }

        internal fun bind(item: Transaction) {
            Picasso.get().load(R.drawable.ic_setting).into(category_image_view)
            merchant_text_view.text = item.merchand
            amount_text_view.text = item.amount.toString()
            status_text_view.text = item.currency
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfTransactionsHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_list_item, parent, false)
        return ListOfTransactionsHolder(v) {
            clickListener(collection[it])
        }
    }

    override fun getItemCount(): Int {
        return collection.size
    }

    override fun onBindViewHolder(holder: ListOfTransactionsHolder, position: Int) {
        holder.bind(collection[position])
    }

}