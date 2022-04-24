package com.metehanbolat.businesslevelcryptoapp.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.metehanbolat.businesslevelcryptoapp.utils.loadImage

class CoinBinding {
    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, coinImage: String) {
            val imageUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/$coinImage.png"
            imageView.loadImage(imageUrl)
        }
    }
}