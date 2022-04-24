package com.metehanbolat.businesslevelcryptoapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.businesslevelcryptoapp.model.detail.DetailResponse
import com.metehanbolat.businesslevelcryptoapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository
): ViewModel() {

    private var _detailResponse: MutableLiveData<DetailResponse> = MutableLiveData()
    val detailResponse: LiveData<DetailResponse> = _detailResponse

    private var _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    private var _onError: MutableLiveData<String> = MutableLiveData()
    val onError: LiveData<String> = _onError

    fun getDetail(symbol: String) = viewModelScope.launch {
        _isLoading.value = true
        when(val request = repository.getDetail(symbol)) {
            is NetworkResult.Success -> {
                _isLoading.value = false
                _detailResponse.value = request.data!!
            }
            is NetworkResult.Error -> {
                _isLoading.value = false
                _onError.value = request.message!!
            }
        }
    }
}