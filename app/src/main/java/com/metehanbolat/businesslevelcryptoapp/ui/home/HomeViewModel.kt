package com.metehanbolat.businesslevelcryptoapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.businesslevelcryptoapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    private val _homeViewState: MutableLiveData<HomeViewState> = MutableLiveData()
    val homeViewState: LiveData<HomeViewState> = _homeViewState

    fun getData() = viewModelScope.launch {
        when(val request = repository.getData()) {
            is NetworkResult.Success -> {
                _homeViewState.value?.let {
                    it.cryptoResponse = request.data
                    it.isLoading = false
                }
            }
            is NetworkResult.Error -> {
                _homeViewState.value?.let {
                    it.onError = request.message
                    it.isLoading = false
                }
            }
        }
    }
}