package com.metehanbolat.businesslevelcryptoapp.ui.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.metehanbolat.businesslevelcryptoapp.base.BaseFragment
import com.metehanbolat.businesslevelcryptoapp.databinding.FragmentDetailBinding

class DetailFragment: BaseFragment<FragmentDetailBinding, DetailViewModel>(
    FragmentDetailBinding::inflate
) {
    override val viewModel by viewModels<DetailViewModel>()

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateFinished() {

    }

    override fun initializeListeners() {
        TODO("Not yet implemented")
    }

    override fun observeEvents() {
        TODO("Not yet implemented")
    }
}