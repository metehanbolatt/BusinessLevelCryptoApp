package com.metehanbolat.businesslevelcryptoapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.metehanbolat.businesslevelcryptoapp.databinding.CryptoRowBinding
import com.metehanbolat.businesslevelcryptoapp.model.success.Data

class HomeRecyclerAdapter(private val listener: CardClickListener): RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    private var coins = emptyList<Data>()

    class HomeViewHolder(private val binding: CryptoRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: CardClickListener, coin: Data) {
            binding.cardClickListener = listener
            binding.coin = coin
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): HomeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CryptoRowBinding.inflate(layoutInflater, parent, false)
                return HomeViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeViewHolder.from(parent)
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) = holder.bind(listener, coins[position])
    override fun getItemCount(): Int = coins.size

    fun setList(newList: List<Data>) {
        coins = newList
        notifyDataSetChanged()
    }
}