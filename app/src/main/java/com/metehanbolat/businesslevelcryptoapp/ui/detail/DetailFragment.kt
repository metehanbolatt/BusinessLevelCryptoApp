package com.metehanbolat.businesslevelcryptoapp.ui.detail

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.metehanbolat.businesslevelcryptoapp.base.BaseFragment
import com.metehanbolat.businesslevelcryptoapp.databinding.FragmentDetailBinding
import com.metehanbolat.businesslevelcryptoapp.model.detail.CoinDetail
import com.metehanbolat.businesslevelcryptoapp.model.detail.DetailResponse
import com.metehanbolat.businesslevelcryptoapp.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import org.json.JSONObject

@AndroidEntryPoint
class DetailFragment: BaseFragment<FragmentDetailBinding, DetailViewModel>(
    FragmentDetailBinding::inflate
) {
    override val viewModel by viewModels<DetailViewModel>()

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateFinished() {
        viewModel.getDetail(args.symbol)
    }

    override fun initializeListeners() {
    }

    override fun observeEvents() {
        with(viewModel) {
            detailResponse.observe(viewLifecycleOwner) {
                parseData(it)
            }

            isLoading.observe(viewLifecycleOwner) {
                handleView(it)
            }

            onError.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun parseData(data: DetailResponse?) {
        val gson = Gson()
        val json = gson.toJson(data?.data)
        val jsonObject = JSONObject(json)
        val jsonArray = jsonObject[args.symbol] as JSONArray

        val coin = gson.fromJson(jsonArray.getJSONObject(0).toString(), CoinDetail::class.java)
        coin?.let {
            with(binding) {
                cryptoDetailImage.loadImage(it.logo)
                cryptoDetailTitle.text = it.name
                cryptoDetailSymbol.text = it.symbol
                cryptoDetailDescription.text = it.description
            }
        }
    }

    private fun handleView(isLoading: Boolean = false) {
        binding.cryptoDetailGroup.isVisible = !isLoading
        binding.cryptoDetailProgressBar.isVisible = isLoading
    }
}