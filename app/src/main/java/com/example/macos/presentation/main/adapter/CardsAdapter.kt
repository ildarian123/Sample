package com.example.macos.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.macos.R
import com.example.macos.databinding.CardItemBinding
import com.example.macos.domain.models.Card

class CardsAdapter(var cardList: List<Card>
) : RecyclerView.Adapter<CardsAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){
            with(cardList[position]){
                binding.cardView.setImageResource(R.drawable.ic_credit_card_foreground)
                binding.amountTextView.text = "${this.amount.toString()} ${this.currency}"
            }
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}