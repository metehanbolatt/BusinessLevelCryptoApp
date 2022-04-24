package com.metehanbolat.businesslevelcryptoapp.ui.home

import com.metehanbolat.businesslevelcryptoapp.model.success.CryptoResponse

data class HomeViewState(
    var cryptoResponse: CryptoResponse? = null,
    var isLoading: Boolean = true,
    var onError: String? = null
)