package com.metehanbolat.businesslevelcryptoapp.ui.home

import androidx.fragment.app.viewModels
import com.metehanbolat.businesslevelcryptoapp.base.BaseFragment
import com.metehanbolat.businesslevelcryptoapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreateFinished() {
        viewModel.getData()
    }

    override fun initializeListeners() {

    }

    override fun observeEvents() {

    }
}