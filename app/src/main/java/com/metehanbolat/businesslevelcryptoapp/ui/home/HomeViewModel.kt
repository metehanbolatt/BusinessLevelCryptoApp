package com.metehanbolat.businesslevelcryptoapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.businesslevelcryptoapp.model.success.CryptoResponse
import com.metehanbolat.businesslevelcryptoapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    private var _cryptoResponse: MutableLiveData<CryptoResponse> = MutableLiveData()
    val cryptoResponse: LiveData<CryptoResponse> = _cryptoResponse

    private var _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    private var _onError : MutableLiveData<String> = MutableLiveData()
    val onError: LiveData<String> = _onError

    fun getData() = viewModelScope.launch {
        _isLoading.value = true
        when(val request = repository.getData()){
            is NetworkResult.Success -> {
                _cryptoResponse.value = request.data!!
                _isLoading.value = false
            }
            is NetworkResult.Error -> {
                _onError.value = request.message!!
                _isLoading.value = false
            }
        }
    }
}