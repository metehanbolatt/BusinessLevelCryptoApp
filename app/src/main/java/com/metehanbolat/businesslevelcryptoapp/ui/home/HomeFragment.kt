package com.metehanbolat.businesslevelcryptoapp.ui.home

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.metehanbolat.businesslevelcryptoapp.base.BaseFragment
import com.metehanbolat.businesslevelcryptoapp.databinding.FragmentHomeBinding
import com.metehanbolat.businesslevelcryptoapp.model.success.Data
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
        with(viewModel){
            cryptoResponse.observe(viewLifecycleOwner) {
                it?.let { cryptoResponse ->
                    cryptoResponse.data?.let { data ->
                        setRecycler(data)
                    }
                }
            }
            isLoading.observe(viewLifecycleOwner) {
                handleViews(it)
            }
            onError.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setRecycler(data: List<Data>) {
        val adapter = HomeRecyclerAdapter(object: CardClickListener {
            override fun onCardClick(coin: Data) {

            }
        })
        binding.recyclerViewHome.adapter = adapter
        adapter.setList(data)
    }

    private fun handleViews(isLoading: Boolean = false) {
        binding.recyclerViewHome.isVisible = !isLoading
        binding.progressBar.isVisible = isLoading
    }

}