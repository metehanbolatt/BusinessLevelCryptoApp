package com.metehanbolat.businesslevelcryptoapp.ui

import androidx.fragment.app.viewModels
import com.metehanbolat.businesslevelcryptoapp.base.BaseFragment
import com.metehanbolat.businesslevelcryptoapp.databinding.FragmentHomeBinding

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreateFinished() {

    }

    override fun initializeListeners() {

    }

    override fun observeEvents() {

    }
}