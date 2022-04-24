package com.metehanbolat.businesslevelcryptoapp.ui.detail

import com.metehanbolat.businesslevelcryptoapp.base.BaseRepository
import com.metehanbolat.businesslevelcryptoapp.network.ApiFactory
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val apiFactory: ApiFactory
): BaseRepository() {

    suspend fun getDetail(symbol: String) = safeApiRequest { apiFactory.getDetail(symbol) }
}